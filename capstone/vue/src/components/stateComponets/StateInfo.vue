<template>
  <div>
    <!-- mapdisplay placeholder-->

    <state-map v-bind:state="state" v-bind:areas="areas" />

    <!-- List of climbing areas in state w/ ratings -->
    <div class="areas my-2 mx-2">
      <h2 id="climbing-areas" class="pl-2 blue white--text">
        {{ state.name }} Climbing Areas ({{ areas.length }}) :
      </h2>
      <v-card
        outlined
        class="my-2 py-2 pl-2"
        v-for="area in areas"
        :key="area.id"
      >
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

<style>
h2 {
  text-align: center;
}
#climbing-areas {
  background-color: #f4511e;
  width: 100%;
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