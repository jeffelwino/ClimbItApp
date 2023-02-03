<template>
  <div class="test">
    <h1>THIS IS MICHAEL'S OWN PERSONAL PRIVATE VIEW</h1>
    <h2 v-if="this.$store.state.user.authorities[0].name == 'ROLE_ADMIN'">
      THIS IS VISIBLE TO ADMINS
    </h2>
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
    console.log(this.$store.state.user);
    console.log(this.$store.state.user.authorities[0].name);
  },
};
</script>

<style>
</style>