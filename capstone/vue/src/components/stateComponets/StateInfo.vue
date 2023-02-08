<template>
  <div>
    <div>
      <h2>{{ state.name }}</h2>
    </div>

    <!-- mapdisplay placeholder-->

    <state-map v-bind:state="state" v-bind:areas="areas" />

    <!-- List of climbing areas in state w/ ratings -->
    <div class="areas">
      <h3>Climbing areas in {{ state.name }}:</h3>

      <v-card v-for="area in areas" :key="area.id">
        <router-link :to="{ name: 'area', params: { id: area.id } }">
          {{ area.name }}
        </router-link>
      </v-card>
    </div>
    <!-- 
        <v-list-item
          v-for="state in $store.state.states"
          v-bind:key="state.name"
        > 
        <router-link v-bind:to="{name: 'state-detail', params: {abbrev: state.abbrev}}">{{ state.name }}</router-link>
        </v-list-item>
        </v-card> -->
  </div>
</template>

<script>
import StateMap from "./StateMap.vue";
import locationService from "../../services/LocationService.js";
export default {
  components: { StateMap },
  name: "state-info",
  data() {
    return {
      state: {},
      areas: [],
    };
  },
  computed: {
    key() {
      return this.$state.store.key;
    },
    // state() {
    //   return this.$store.state.activeState;
    // },
    // areas() {
    //   return this.$store.state.activeAreas;
    // },
  },
  created() {
    locationService
      .getStateByAbbrev(this.$route.params.abbrev)
      .then((response) => {
        if (response.status == 200) {
          this.state = response.data;
          locationService
            .getAreasByState(this.state.abbrev)
            .then((response) => {
              if (response.status == 200) {
                this.$store.commit("SET_ACTIVE_AREAS", response.data);
                this.areas = response.data;
              }
            });
        }
      });
  },
};
</script>

<style scoped>
h2 {
  text-align: center;
}
.placeholdermap {
  margin-top: 5%;
  background-color: red;
  width: 90%;
  height: 20rem;
  margin-left: 5%;
  border: 1px solid black;
  text-align: center;
}
</style>