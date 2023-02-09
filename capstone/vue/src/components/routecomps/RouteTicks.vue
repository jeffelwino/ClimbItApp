<template>
  <v-container class="px-3">
    <v-card>
      <v-card-title class="justify-center text-h6 text-md-h5 text-lg-h4">
        Latest ClimbedIts For <br />
        {{ route.name }}
      </v-card-title>
      <v-divider></v-divider>
      <tick-display
        class="mb-2"
        v-bind:route-ticks="false"
        v-for="tick in limitedList"
        :key="tick.id"
        :tick="tick"
        :offProfile="true"
      />

      <v-btn
        class="ml-1 mb-2"
        :class="{ active: seeAll }"
        small
        @click="toggleLimit"
        >{{ seeAll ? "HIDE" : "SEE ALL" }}
      </v-btn>
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
      seeAll: false,
    };
  },
  components: { TickDisplay },
  props: ["route"],
  computed: {
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
      this.seeAll = this.seeAll ? false : true;
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