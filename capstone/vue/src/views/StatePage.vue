<template>
  <v-container>
    <div class="mx-3">
      <v-row class="mt-n15 pb-8 mR-5 justify-start">
        <v-btn x-small @click="navigateUp" exact class="back-button">
          <v-icon x-small>mdi-arrow-left-circle</v-icon>
          To Home
        </v-btn>
      </v-row>
    </div>
    <!-- Component -->
    <h2 class="secondary">{{ state.name }}</h2>
    <state-tools
      v-if="this.$store.state.user.authorities[0].name == 'ROLE_ADMIN'"
    />
    <div>
      <!-- component -->
      <state-info />
    </div>
  </v-container>
</template>

<script>
import StateInfo from "../components/stateComponets/StateInfo";
import StateTools from "../components/adminTools/StateTools.vue";
import locationService from "../services/LocationService.js";

export default {
  name: "state-page",
  components: { StateInfo, StateTools },
  data() {
    return {
      state: {},
    };
  },
  methods: {
    navigateUp() {
      this.$router.push({ name: "home" });
    },
  },
  created() {
    locationService
      .getStateByAbbrev(this.$route.params.abbrev)
      .then((response) => {
        if (response.status == 200) {
          this.state = response.data;
          this.$store.commit("SET_ACTIVE_STATE", this.state);
        }
      });
  },
};
</script>

<style>
</style>