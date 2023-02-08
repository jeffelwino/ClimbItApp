<template>
  <v-container class="profile-ticks">
    <h3>{{ profile.name }}'s Latest ClimbedIts:</h3>
    <tick-display
      class="tick-cards"
      v-for="tick in ticks"
      :key="tick.id"
      :tick="tick"
      :showNote="true"
      :onProfile="false"
      :offRoute="true"
    />
    <v-btn v-show="ticks.length > limit" @click="toggleLimit">See All</v-btn>
  </v-container>
</template>

<script>
import TickDisplay from "../TickDisplay.vue";
import tickService from "../../services/TickService.js";
export default {
  /*
   ** limit on number of ticks displayed.
   ** if this changes, also change
   ** toggleLimit value in methods
   */

  limit: 3,
  components: { TickDisplay },
  name: "profile-ticks",
  props: ["profile"],
  data() {
    return {
      ticks: [],
    };
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
    tickService.listByProfile(this.$route.params.id).then((response) => {
      if (response.status == 200) {
        this.ticks = response.data;
      }
    });
  },
};
</script>

<style>
.tick-cards {
  font-size: small;
}
</style>