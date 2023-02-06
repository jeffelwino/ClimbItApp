<template>
  <div class="tick-display">
    <v-card class="mb-2" height="4rem">
      <v-layout class="justify-space-around">
        <span class="mt-2 text-subtitle-2 text-sm-h5">
          {{ profile.name }} {{ tick.date }}</span
        >
        <v-spacer></v-spacer>
        <v-rating
          readonly
          :value="tick.rating"
          class="mr-2 mt-2"
          color="yellow darken-3"
          background-color="grey darken-1"
          empty-icon="$ratingFull"
          dense
          size="0.75rem"
        ></v-rating>
        <p v-if="showNote">{{ tick.note }}</p>
      </v-layout>
    </v-card>
  </div>
</template>

<script>
export default {
  name: "tick-display",
  props: ["tick", "showNote"],
  computed: {
    route() {
      return this.$store.state.routes.find((r) => {
        return r.id == this.tick.routeId;
      });
    },
    profile() {
      return this.$store.state.profiles.find((p) => {
        return p.id == this.tick.profileId;
      });
    },
  },
};
</script>

<style>
</style>