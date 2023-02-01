<template>
  <div class="state-map">
    <h2>{{ state.name }}</h2>
    <state-map v-bind:state="state"/>
    <state-info v-bind:state="state"/>
  </div>
</template>

<script>
import StateInfo from '../components/StateInfo.vue'
import StateMap from '../components/StateMap.vue'
export default {
  components: {StateInfo, StateMap},
  name: "state",
  data() {
    return {
      state: {
        abbrev: "",
        name: "",
        areas: 0,
      },
    };
  },
  methods: {
    loadState() {
      this.state = this.$store.state.states.find((estado) => {
        return estado.abbrev == this.$route.params.abbrev;
      });
    },
  },
  created() {
    this.loadState();
  },
};
</script>
<style scoped>

</style>