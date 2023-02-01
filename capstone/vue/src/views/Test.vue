<template>
  <div class="test">
    <h1>THIS IS MICHAEL'S OWN PERSONAL PRIVATE VIEW</h1>
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
    console.log(this.$store.state.user.id);
  },
};
</script>

<style>
</style>