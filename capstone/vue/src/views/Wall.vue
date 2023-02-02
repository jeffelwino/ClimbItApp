<template>
  <div class="wall">
    <h2>Wall Page</h2>
    <h2>{{ wall.name }}</h2>
    <wall-detail v-bind:wall="wall" />
  </div>
</template>

<script>
import WallDetail from "../components/wall/WallDetail.vue";
export default {
  name: "wall",
  components: { WallDetail },
  data() {
    return {
      wall: {
        id: "",
        cragId: "",
        name: "",
        description: "",
      },
    };
  },
  methods: {
    loadWall() {
      this.wall = this.$store.state.walls.find((w) => {
        return w.id == this.$route.params.id;
      });
    },
  },
  created() {
    this.loadWall();
  },
};
</script>

<style>
</style>