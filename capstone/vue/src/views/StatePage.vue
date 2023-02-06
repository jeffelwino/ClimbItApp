<template>
  <v-container>
    <state-tools
      v-if="this.$store.state.user.authorities[0].name == 'ROLE_ADMIN'"
    />
    <div>
      <state-info />
    </div>
  </v-container>
</template>

<script>
import StateInfo from "../components/stateComponets/StateInfo";
import StateTools from "../components/adminTools/StateTools.vue";

export default {
  name: "state-page",
  components: { StateInfo, StateTools },
  computed: {
    state() {
      return this.$store.state.states.find((s) => {
        return s.abbrev == this.$route.params.abbrev;
      });
    },
  },
};
</script>

<style>
</style>