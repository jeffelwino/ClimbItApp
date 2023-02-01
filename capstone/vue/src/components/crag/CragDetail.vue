<template>
  <div class="crag">
    <div class="description">
      <h3>Description:</h3>
      <p>{{ crag.description }}</p>
    </div>
    <div class="walls">
      <ul>
        <li v-for="wall in walls" :key="wall.id">
          <router-link :to="{ name: 'wall', params: { id: wall.id } }">{{
            wall.name
          }}</router-link>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: "crag-detail",
  props: ["crag"],
  data() {
    return {
      walls: [],
    };
  },
  methods: {
    loadWalls() {
      this.$store.state.walls.forEach((wall) => {
        console.log("test");
        if (wall.crag_id == this.crag.id) {
          this.walls.push(wall);
        }
      });
    },
  },
  created() {
    this.loadWalls();
  },
};
</script>

<style>
</style>