<template>
  <div class="route">
  
    
    <route-header v-bind:route="route" />
    <route-detail v-bind:route="route" />
  </div>
</template>

<script>
import RouteDetail from "../components/routecomps/RouteDetail.vue";
import RouteHeader from "../components/routecomps/RouteHeader.vue";
export default {
  name: "route",
  components: { RouteDetail, RouteHeader },
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