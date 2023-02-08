<template>
  <v-container>
    <wall-card
      v-for="wall in walls"
      :key="wall.id"
      v-bind:wall="wall"
    ></wall-card>
  </v-container>
</template>

<script>
import WallCard from "./WallCard.vue";
import locationService from "../../services/LocationService.js";
export default {
  components: { WallCard },
  data() {
    return {
      walls: [],
    };
  },
  created() {
    locationService.getWallsByCragId(this.$route.params.id).then((response) => {
      if (response.status == 200) {
        this.walls = response.data;
      }
    });
  },
};
</script>

<style>
</style>