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
  data() {
    return {
      ticks: [],
    };
  },
  methods: {
    loadTicks() {
      this.ticks = this.$store.state.ticks.filter((tick) => {
        return tick.profile_id == this.$route.params.id;
      });
    },
  },
  computed: {
    profile() {
      return this.$store.state.profiles.find((profile) => {
        return profile.id == this.$route.params.id;
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