<template>
  <div class="wall">
    <div class="description">
      <h3>Description:</h3>
      <p>{{ wall.description }}</p>
    </div>
    <div class="routes">
      <ul>
        <li v-for="route in routes" :key="route.id">
          <router-link :to="{ name: 'route-page', params: { id: route.id } }">
            {{ route.name }} ({{ route.grade }})
          </router-link>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: "wall-detail",
  props: ["wall"],
  data() {
    return {
      routes: [],
    };
  },
  methods: {
    loadRoutes() {
      this.$store.state.routes.forEach((route) => {
        if (route.wall_id == this.wall.id) {
          this.routes.push(route);
        }
      });
    },
  },
  created() {
    this.loadRoutes();
  },
};
</script>

<style>
</style>