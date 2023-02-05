<template>
  <v-container class="px-3">
    <v-card>
      <v-card
        class="text-h7 text-md-h5 text-lg-h4 text-truncate">
        Latest Ticks For {{ route.name }}
      </v-card>
      <v-divider></v-divider>
      <tick-display
        v-bind:route-ticks="false"
        v-for="tick in limitedList"
        :key="tick.id"
        :tick="tick"
      />
      <v-btn @click="toggleLimit">See All</v-btn>
    </v-card>
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