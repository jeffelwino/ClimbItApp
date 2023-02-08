<template>
  <v-container>
    <div class="home mt-n10">
      <home-map />

      <v-sheet class="mt-5">
        <state-list :states="states" />
      </v-sheet>
    </div>
  </v-container>
</template>

<script>
import HomeMap from "../components/HomeMap.vue";
import StateList from "../components/StateList.vue";
import locationService from "../services/LocationService.js";

export default {
  components: { HomeMap, StateList },
  name: "home",
  data() {
    return {
      states: [],
    };
  },
  created() {
    if (this.states.length == 0) {
      locationService.loadStates().then((response) => {
        if (response.status == 200) {
          this.states = response.data;
        }
      });
    }
  },
};
</script>
