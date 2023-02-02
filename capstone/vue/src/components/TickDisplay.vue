<template>
  <div class="tick-display">

    <v-card class="mb-2">
      <v-layout class="justify-space-around">
        <h6>{{ profile.name }} climbed {{ route.name }} on {{ tick.date }}</h6>
        <v-spacer></v-spacer>
    <v-rating
      readonly
      :value="tick.rating"
      class="mr-2"
      color="yellow darken-3"
      background-color="grey darken-1"
      empty-icon="$ratingFull"
      dense
      x-small
    ></v-rating>
    <p v-if="tick-note">{{ tick.note }}</p>

      </v-layout>
    
    </v-card>
  </div>
</template>

<script>
export default {
  name: "tick-display",
  props: ["tick", "tick-note"],
  computed: {
    route() {
      return this.$store.state.routes.find((r) => {
        return r.id == this.tick.routeId;
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