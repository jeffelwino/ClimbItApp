<template>
  <div class="state-map">
    <h2>{{ state.name }}</h2>
  </div>
</template>

<script>
export default {
  components: {},
  name: "state",
  data() {
    return {
      state: {
        abbrev: "",
        name: "",
        areas: 0,
      },
    };
  },
  methods: {
    loadState() {
      this.state = this.$store.state.states.find((estado) => {
        return estado.abbrev == this.$route.params.abbrev;
      });
    },
  },
  created() {
    this.loadState();
  },
};
</script>
<style scoped>
</style>