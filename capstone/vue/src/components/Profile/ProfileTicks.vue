<template>
  <div class="profile-ticks">
    <h3>Here are {{ profile.name }}'s latest ascents:</h3>
    <tick-display v-bind:route-ticks="true" v-for="tick in ticks" :key="tick.id" :tick="tick" />
  </div>
</template>

<script>
import TickDisplay from "../TickDisplay.vue";
export default {
  components: { TickDisplay },
  name: "profile-ticks",
  props: ["profile"],
  data() {
    return {
      ticks: [
        // {
        //   id:0,
        //   profile_id: 0,
        //   routeId: 0,
        //   date: "",
        //   note: "",
        //   rating: 0,
        // },
        // {
        //   id: 2,
        //   profile_id: 1,
        //   routeId: 6,
        //   date: "6/11/2021",
        //   note: "Stout for the grade, but very fun. Onsight ascent, sketchy move to the anchors though.",
        //   rating: 3,
        // },
      ],
    };
  },
  methods: {
      loadTicks() {
      this.ticks = this.$store.state.ticks.find((tick) => {
        return tick.profile_id == this.$route.params.id;
      });
    },
  },
  created() {
    this.loadTicks();
  },
};
</script>

<style>
</style>