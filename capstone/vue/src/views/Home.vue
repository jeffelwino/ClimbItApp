<template>
  <v-container>
    <div class="home mt-n10">
      <home-map />

      <v-sheet class="mt-5">
        <state-list></state-list>
      </v-sheet>
    </div>
  </v-container>
</template>

<script>
import HomeMap from "../components/HomeMap.vue";
import StateList from "../components/StateList.vue";

export default {
  components: { HomeMap, StateList },
  name: "home",
};
</script>
