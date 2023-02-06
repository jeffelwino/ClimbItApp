<template>
  <div class="profile-ticks">
    <h3>Here are {{ profile.name }}'s latest ticks:</h3>
    <tick-display
      v-for="tick in ticks"
      :key="tick.id"
      :tick="tick"
      :showNote="true"
    />
  </div>
</template>

<script>
import TickDisplay from "../TickDisplay.vue";
export default {
  components: { TickDisplay },
  name: "profile-ticks",
  props: ["profile"],
  computed: {
    ticks() {
      return this.$store.state.ticks.filter((tick) => {
        return tick.profileId == this.$route.params.id;
      });
    },
  },
};
</script>

<style>
</style>