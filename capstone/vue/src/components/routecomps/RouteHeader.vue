<template>
  <div class="route-header">
    <!-- route name and grade box -->
    <v-container class="blue mt-n12">
      <v-row class="justify-center blue">
        <h3 class="white--text">{{ route.name }} ({{ route.grade }})</h3>
      </v-row>

      <!-- return to wall page button -->
      <v-row class="pb-2 justify-space-around">
        <!-- <v-btn small v-bind:to="{ name: 'wall', params: '{id: route.wallId}' }"> -->

        <!-- Tickbox button -->
        <tick-box :route="route" />

        <!-- add to to-do list button -->
        <v-btn
          small
          v-if="!isHidden"
          v-on:click="isHidden = true"
          @click="addTodo"
        >
          Wanna ClimbIt
        </v-btn>
      </v-row>
      <v-card class="blue"> </v-card>
    </v-container>
  </div>
</template>

<script>
import TickBox from "./TickBox.vue";

export default {
  components: { TickBox },
  name: "route-header",
  props: ["route"],
  data() {
    return {
      isHidden: false,
    };
  },

  methods: {
    addTodo() {
      this.$store.commit("ADD_TODO", {
        profileId: this.$store.state.user.id,
        routeId: this.route.id,
      });
    },
  },
  // computed: {
  //   toDo() {
  //     if(this.profile.ticks.contains(this.$route.routeId))
  //   },
  // }
};
</script>

<style>
</style>