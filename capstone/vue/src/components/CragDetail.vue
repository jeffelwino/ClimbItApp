<template>
  <div class="crag">
    <div class="description">
      <p>Description:</p>
      <p>{{ crag.description }}</p>
    </div>
    <div class="walls">
      <ul>
        <li v-for="wall in walls" :key="wall.id">
          {{ wall.name }}
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
      this.store.state.walls.forEach((wall) => {
        if (wall.crag_id == this.crag.id) {
          this.crags.push(wall);
        }
      });
    },
  },
};
</script>

<style>
</style>