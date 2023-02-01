<template>
  <div class="crag">
    <h2>Crag Page</h2>
    <h2>{{ crag.name }}</h2>
    <crag-map v-bind:crag="crag"/>
    <crag-detail v-bind:crag="crag" />
  </div>
</template>

<script>
import CragDetail from "../components/CragDetail.vue";
import CragMap from '../components/CragMap.vue';
export default {
  components: { CragDetail, CragMap },
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
        area_id: "",
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