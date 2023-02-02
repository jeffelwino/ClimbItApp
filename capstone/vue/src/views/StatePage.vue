<template>
<v-container>
  <div>
    <state-info />
    <state-map v-bind:state="state" />
    </div>
  </v-container>
</template>

<script>
import StateInfo from "../components/stateComponets/StateInfo";
import StateMap from "../components/stateComponets/StateMap.vue";
export default {
  name: "state-detail",
  components: { StateInfo, StateMap },
};
</script>

<style>
</style>