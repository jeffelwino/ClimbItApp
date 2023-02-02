<template>
  <div class="route-header">
    <!-- route name and grade box -->
    <v-container class="blue mt-n12">
      <v-row class="justify-center blue">
        <h3 class="white--text">{{ route.name }} ({{ route.grade }})</h3>
      </v-row>

      <v-row class="pb-2 justify-space-around">
        <!-- Tickbox button -->
        <tick-box :route="route" />

        <v-btn small> Wanna ClimbIt </v-btn>
      </v-row>
      <v-card class="blue"> </v-card>
    </v-container>

    <!-- tick box button -->
    <!-- add to to-do list button -->
  </div>
</template>

<script>
import TickBox from "./TickBox.vue";

export default {
  components: { TickBox },
  name: "route-header",
  props: ["route"],
  computed: {},
};
</script>

<style>
</style>