<template>
  <div class="crag">
    <h2>Crag Page</h2>
    <h2>{{ crag.name }}</h2>
    <!-- Refactored into the container -->
    <wall-card-container v-bind:crag="crag"/>
  </div>
</template>

<script>
import WallCardContainer from "../components/WallCardContainer.vue";

export default {
  components: { WallCardContainer },
  name: "crag",
  methods: {
    loadCrag() {
      this.crag = this.$store.state.crags.find((c) => {
        return c.id == this.$route.params.id;
      });
    },
  },
  data() {
    return {
      crag: {
        id: "",
        areaId: "",
        name: "",
        description: "",
        latitude: "",
        longitude: "",
      },
    };
  },
  created() {
    this.loadCrag();
  },
};
</script>

<style>
</style>