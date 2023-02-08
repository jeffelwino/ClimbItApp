<template>
  <v-container class="px-3">
    <v-card>
      <v-card-title class="justify-center text-h6 text-md-h5 text-lg-h4">
        Latest ClimbedIts For <br />
        {{ route.name }}
      </v-card-title>
      <v-divider></v-divider>
      <tick-display
        v-bind:route-ticks="false"
        v-for="tick in limitedList"
        :key="tick.id"
        :tick="tick"
        :offProfile="true"
      />
      <v-btn v-show="ticks.length > limit" @click="toggleLimit">See All</v-btn>
    </v-card>
  </v-container>
</template>

<script>
import TickDisplay from "../TickDisplay.vue";
import tickService from "../../services/TickService.js";
export default {
  name: "route-ticks",
  data() {
    return {
      ticks: [],
      /*
       ** limit on number of ticks displayed. if this changes, also change
       ** toggleLimit value in methods
       */
      limit: 2,
    };
  },
  components: { TickDisplay },
  props: ["route"],
  computed: {
    //   ticks() {
    //     return this.$store.state.ticks.filter((t) => {
    //       return t.routeId == this.route.id;
    //     });
    //   },
    limitedList() {
      return this.limit ? this.ticks.slice(0, this.limit) : this.ticks;
    },
  },
  methods: {
    toggleLimit() {
      //see note above limit property
      if (this.limit !== null) {
        this.limit = null;
      } else {
        this.limit = 2;
      }
    },
  },
  created() {
    tickService.listByRoute(this.$route.params.id).then((response) => {
      if (response.status == 200) {
        this.ticks = response.data;
      }
    });
  },
};
</script>

<style>
</style>