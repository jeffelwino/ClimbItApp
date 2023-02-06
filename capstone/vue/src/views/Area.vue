<template>
  <div class="area">
    <!-- return to state page button -->
    <div class="mx-5">
      <v-row class="mt-n10 pb-5 justify-start">
        <v-btn
          x-small
          v-bind:to="{
            name: 'state-page',
            params: { abbrev: area.stateAbbrev },
          }"
          exact
        >
          <v-icon x-small>mdi-arrow-left-circle</v-icon>
          to state
        </v-btn>
      </v-row>
    </div>

    <area-tools
      v-if="this.$store.state.user.authorities[0].name == 'ROLE_ADMIN'"
    />
    <h2>{{ area.name }}</h2>
    <area-map v-bind:area="area" />
    <!-- <new-area-form-map v-bind:area="area"/> -->
    <area-detail v-bind:area="area" />
    <!-- <comment-container  -->
  </div>
</template>

<script>
import AreaDetail from "../components/area/AreaDetail.vue";
//import NewAreaFormMap from '../components/area/NewAreaFormMap.vue'
import AreaMap from "../components/area/AreaMap.vue";
import AreaTools from "../components/adminTools/AreaTools.vue";
export default {
  
  components: { AreaDetail, AreaMap, AreaTools,  }, //NewAreaFormMap
  name: "area",
  computed: {
    area() {
      return this.$store.state.areas.find((area) => {
        return area.id == this.$route.params.id;
      });
    },
  },
};
</script>

<style>
</style>