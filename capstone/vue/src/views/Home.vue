<template>
  <v-container>
    <div class="home mt-n10">
      <display-map />

      <v-sheet class="mt-5">
        <state-list></state-list>
      </v-sheet>
    </div>
  </v-container>
</template>

<script>
import DisplayMap from "../components/HomeMap.vue";
import StateList from "../components/StateList.vue";
import profileService from "../services/ProfileService.js";

export default {
  components: { DisplayMap, StateList },
  name: "home",
  created() {
    profileService.loadProfiles().then((response) => {
      if (response.status == 200) {
        console.log(response.data);
      }
    });
  },
};
</script>
