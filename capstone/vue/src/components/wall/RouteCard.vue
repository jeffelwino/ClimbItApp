<template>
  <v-card @click="navigateToRoute()">
    <v-layout class="mr-4 py-2">
      <span>{{ route.name }} ({{ route.grade }}) </span>
      <v-spacer></v-spacer>
      <v-rating
        readonly
        small
        dense
        v-model="averageRating"
        half-increments
        color="yellow darken-3"
        background-color="grey darken-1"
        empty-icon="$ratingFull"
      ></v-rating>
    </v-layout>

    <v-divider class="blue"></v-divider>
  </v-card>
</template>

<script>
import tickService from "../../services/TickService.js";
export default {
  name: "route-card",
  props: ["route"],
  data() {
    return {
      ticks: [],
    };
  },
  created() {
    tickService.listByRoute(this.route.id).then((response) => {
      if (response.status == 200) {
        this.ticks = response.data;
      }
    });
  },
  computed: {
    averageRating() {
      let sum = 0;
      this.ticks.forEach((tick) => {
        sum += tick.rating;
      });
      return (sum /= this.ticks.length);
    },
  },
  methods: {
    navigateToRoute() {
      this.$router.push({ name: "route-page", params: { id: this.route.id } });
    },
  },
};
</script>

<style>
</style>