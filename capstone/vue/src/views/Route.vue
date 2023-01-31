<template>
  <div class="route">
    <h2>Route Page</h2>
    <h2>{{ route.name }} ({{ route.grade }})</h2>
    <route-detail v-bind:route="route" />
  </div>
</template>

<script>
import RouteDetail from "../components/RouteDetail.vue";
export default {
  name: "route",
  components: { RouteDetail },
  data() {
    return {
      route: {
        id: "",
        wall_id: "",
        name: "",
        grade: "",
        height: "",
        style: "",
      },
    };
  },
  methods: {
    loadRoute() {
      this.route = this.$store.state.routes.find((r) => {
        return r.id == this.$route.params.id;
      });
    },
  },
  created() {
    this.loadRoute();
  },
};
</script>

<style>
</style>