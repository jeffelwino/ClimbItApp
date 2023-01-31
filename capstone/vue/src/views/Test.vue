<template>
  <div class="test">
    <h2>Test landing page</h2>
    <h2>{{ area.name }}</h2>
    <p>{{ area.description }}</p>
  </div>
</template>

<script>
export default {
  name: "test",
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