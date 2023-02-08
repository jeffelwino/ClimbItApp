<template>
  <div class="wall">
    <div class="description mx-5">
      <h2>{{ wall.name }}</h2>
      <h3>Description:</h3>
      <p>{{ wall.description }}</p>
    </div>
    <div class="routes mx-3">
      <route-card v-for="route in routes" :key="route.id" :route="route" />
    </div>
  </div>
</template>

<script>
import RouteCard from "./RouteCard.vue";
import locationService from "../../services/LocationService.js";

export default {
  name: "wall-detail",
  components: { RouteCard },
  data() {
    return {
      wall: {},
      routes: [],
    };
  },
  created() {
    locationService.getWallById(this.$route.params.id).then((response) => {
      if (response.status == 200) {
        this.wall = response.data;
        locationService.getRoutesByWall(this.wall.id).then((response) => {
          if (response.status == 200) {
            this.routes = response.data;
          }
        });
      }
    });
  },
};
</script>

<style>
</style>