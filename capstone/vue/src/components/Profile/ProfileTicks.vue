<template>
  <v-container class="profile-ticks">
    <h3>{{ profile.name }}'s Latest ClimbedIts:</h3>
    <tick-display
      class="tick-cards"
      :class="{ active: seeAll }"
      v-for="tick in limitedList"
      :key="tick.id"
      :tick="tick"
      :showNote="true"
      :onProfile="false"
      :offRoute="true"
      @click="toggleLimit"
    />
    <v-btn @click="toggleLimit"> {{ seeAll ? "HIDE" : "SEE ALL" }}</v-btn>
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

  components: { TickDisplay },
  name: "profile-ticks",
  props: ["profile"],
  data() {
    return {
      ticks: [],
      limit: 2,
      seeAll: false,
    };
  },
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