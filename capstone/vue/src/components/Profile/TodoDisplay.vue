<template>
  <div class="todo">
    <v-card outlined @click.prevent="navigateToPage">
      <h5>{{ route.name }}</h5>
    </v-card>
  </div>
</template>

<script>
import locationService from "../../services/LocationService.js";
export default {
  name: "todo-display",
  props: ["todo"],
  data() {
    return {
      route: {},
    };
  },

  methods: {
    navigateToPage() {
      this.$router.push({
        name: "route-page",
        params: { id: this.route.id },
      });
    },
  },
  created() {
    locationService.getRouteById(this.todo.routeId).then((response) => {
      if (response.status == 200) {
        this.route = response.data;
      }
    });
  },
};
</script>

<style>
</style>