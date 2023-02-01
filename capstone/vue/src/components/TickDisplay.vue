<template>
  <div class="tick-display">
    <h4>{{ profile.name }} climbed {{ route.name }} on {{ tick.date }}</h4>
    <v-rating
      readonly
      :value="tick.rating"
      color="yellow darken-3"
      background-color="grey darken-1"
      empty-icon="$ratingFull"
      hover
      medium
    ></v-rating>
    <p>{{ tick.note }}</p>
  </div>
</template>

<script>
export default {
  name: "tick-display",
  props: ["tick"],
  computed: {
    route() {
      return this.$store.state.routes.find((r) => {
        return r.id == this.tick.route_id;
      });
    },
    profile() {
      return this.$store.state.profiles.find((p) => {
        console.log(this.tick);
        return p.id == this.tick.profile_id;
      });
    },
  },
};
</script>

<style>
</style>