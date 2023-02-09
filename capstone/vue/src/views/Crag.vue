<template>
  <v-container fluid class="crag">
    <!-- return to area page button -->
    <div class="mx-5">
      <v-row class="mt-n10 pb-2 justify-start">
        <v-btn
          x-small
          v-bind:to="{ name: 'area', params: { id: crag.areaId } }"
        >
          <v-icon x-small>mdi-arrow-left-circle</v-icon>
          to area
        </v-btn>
      </v-row>
    </div>

    <crag-tools
      v-if="this.$store.state.user.authorities[0].name == 'ROLE_ADMIN'"
    />
    <v-sheet>
      <h2 id="header" class="secondary pl-5 mt-5 ml-6">{{ crag.name }}</h2>
      <!-- Refactored into the container -->
      <wall-card-container v-bind:crag="crag" />
      <crag-comment class="comments" v-bind:crag="crag" />
    </v-sheet>
  </v-container>
</template>

<script>
import CragTools from "../components/adminTools/CragTools.vue";
import WallCardContainer from "../components/crag/WallCardContainer.vue";
import CragComment from "../components/commentComps/CragComment.vue";
import locationService from "../services/LocationService.js";

export default {
  components: { WallCardContainer, CragComment, CragTools },
  name: "crag",
  data() {
    return {
      crag: {},
    };
  },
  created() {
    locationService.getCragById(this.$route.params.id).then((response) => {
      if (response.status == 200) {
        this.crag = response.data;
      }
    });
  },
};
</script>

<style>
#header {
  color: white;
  width: 87%;
  text-align: center;
}
.comments {
  width: 87%;
  margin-left: 1.5rem;
}
</style>