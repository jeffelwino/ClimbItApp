<template>
  <div>
    <div>
      <h2>{{ state.name }}</h2>
    </div>

    <!-- mapdisplay placeholder-->

    <state-map v-bind:state="state" v-bind:areas="areas"/>


    <!-- List of climbing areas in state w/ ratings -->
    <div class="areas">
        <h3>Climbing areas in {{state.name}}:</h3>
      <ul>
        <li v-for="area in areas" :key="area.id">
          <router-link :to="{ name: 'area', params: { id: area.id } }">
            {{ area.name }}
          </router-link>
        </li>
      </ul>
    </div>
    <!-- <v-card>
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
import StateMap from "../components/StateMap.vue";
export default {
  components: { StateMap },
  name: "state-info",
  data() {
    return {
      state: {
        abbrev: "",
        name: "",
        areas: 0,
      },
      areas: [],
    };
  },
  methods: {
    loadState() {
      this.state = this.$store.state.states.find((estado) => {
        return estado.abbrev == this.$route.params.abbrev;
      });
    },
    loadRoutes() {
      this.$store.state.areas.forEach((area) => {
        if (area.stateAbbrev == this.state.abbrev) {
          this.areas.push(area);
        }
      });
    },
  },
  created() {
    this.loadState();
    this.loadRoutes();
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