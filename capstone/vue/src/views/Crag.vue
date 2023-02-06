<template>
  <div class="crag">
    <!-- return to area page button -->
    <div class="mx-5">
      <v-row class="mt-n10 pb-5 justify-start">
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
    <h2>{{ crag.name }}</h2>
    <!-- Refactored into the container -->
    <wall-card-container v-bind:crag="crag" />
    <crag-comment v-bind:crag="crag" />
  </div>
</template>

<script>
import CragTools from "../components/adminTools/CragTools.vue";
import WallCardContainer from "../components/WallCardContainer.vue";
import CragComment from "../components/CragComment.vue";

export default {
  components: { WallCardContainer, CragComment, CragTools },
  name: "crag",
  computed: {
    crag() {
      return this.$store.state.crags.find((c) => {
        return c.id == this.$route.params.id;
      });
    },
  },
};
</script>

<style>
</style>