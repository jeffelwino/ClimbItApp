<template>
  <v-container class="px-3">
    <div class="route-ticks">
      <h3>Latest Ticks For {{ route.name }}</h3>
      <tick-display v-for="tick in limitedList" :key="tick.id" :tick="tick" />
      <v-btn @click="toggleLimit">See All</v-btn>
    </div>
  </v-container>
</template>

<script>
import TickDisplay from "../TickDisplay.vue";
export default {
  name: "route-ticks",
  data() {
    return {
      //limit on number of ticks displayed. if this changes, also change toggleLimit value
      limit: 2,
    };
  },
  components: { TickDisplay },
  props: ["route"],
  computed: {
    ticks() {
      return this.$store.state.ticks.filter((t) => {
        return t.routeId == this.route.id;
      });
    },
    limitedList() {
      return this.limit ? this.ticks.slice(0, this.limit) : this.ticks;
    },
  },
  methods: {
    toggleLimit() {
      //see note above limit property
      if (this.limit !== null) {
        this.limit = null;
      } else {
        this.limit = 2;
      }
    },
  },
};
</script>

<style>
</style>