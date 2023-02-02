<template>
  <div class="profile-ticks">
    <h3>Here are {{ profile.name }}'s latest ascents:</h3>
    <tick-display v-for="tick in ticks" :key="tick.id" :tick="tick" />
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
        {
          id: 1,
          profile_id: 1,
          routeId: 9,
          date: "10/18/2022",
          note: "Great climb, loved the moves on the arete. Redpoint after giving it a burn on toprope earlier in the week",
          rating: 4,
        },
        {
          id: 2,
          profile_id: 1,
          routeId: 6,
          date: "6/11/2021",
          note: "Stout for the grade, but very fun. Onsight ascent, sketchy move to the anchors though.",
          rating: 3,
        },
      ],
    };
  },
};
</script>

<style>
</style>