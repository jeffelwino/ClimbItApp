<template>
  <div class="area">
    <div class="weather">
      The weather the next 5 days is going to be perfect for climbing!
    </div>
    <p>{{ area.description }}</p>
  </div>
</template>

<script>
export default {
  name: "area-detail",
  props: ["area"],
  data() {
    return {
      crags: [],
    };
  },
  methods: {
    loadCrags() {
      this.$store.state.crags.forEach((crag) => {
        if (crag.area_id == this.area.id) {
          this.crags.push(crag);
        }
      });
    },
  },
};
</script>

<style scoped>
.weather {
  background-color: aqua;
}
</style>