<template>
  <div class="route-ticks">
    <h3>Here are the latest ticks for {{ route.name }}</h3>
    <tick-display v-for="tick in ticks" :key="tick.id" :tick="tick" />
  </div>
</template>

<script>
import TickDisplay from "../TickDisplay.vue";
export default {
  name: "route-ticks",
  components: { TickDisplay },
  props: ["route"],
  computed: {
    ticks() {
      return this.$store.state.ticks.filter((t) => {
        return t.route_id == this.route.id;
      });
    },
  },
};
</script>

<style>
</style>