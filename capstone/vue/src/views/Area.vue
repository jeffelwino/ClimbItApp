<template>
  <div class="area">
    <h2>{{ area.name }}</h2>
    <!-- <area-map /> -->
    <area-detail v-bind:area="area" />
    <!-- <comment-container  -->
  </div>
</template>

<script>
import AreaDetail from "../components/AreaDetail.vue";
export default {
  components: { AreaDetail },
  name: "area",
  methods: {
    loadArea() {
      this.area = this.$store.state.areas.find((a) => {
        return a.id == this.$route.params.id;
      });
    },
  },
  data() {
    return {
      area: {
        name: "",
        id: "",
        description: "",
        latitude: "",
        longitude: "",
      },
    };
  },
  created() {
    this.loadArea();
  },
};
</script>

<style>
</style>