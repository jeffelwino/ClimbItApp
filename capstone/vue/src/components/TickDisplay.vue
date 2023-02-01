<template>
  <div class="tick-display">
    <h4>
      {{ profile.name ? profile.name + " climbed " : "" }}{{ route.name }} on
      {{ tick.date }}
    </h4>
    <p>{{ tick.rating }} Stars!</p>
    <p>{{ tick.note }}</p>
  </div>
</template>

<script>
export default {
  name: "tick-display",
  props: ["tick", "profile"],
  computed: {
    route() {
      return this.$store.state.routes.find((r) => {
        return r.id == this.tick.route_id;
      });
    },
  },
};
</script>

<style>
</style>