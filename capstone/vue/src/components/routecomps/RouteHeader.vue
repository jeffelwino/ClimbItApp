<template>
  <div class="route-header">
    <v-container class="main-body mt-n12">
      <!-- route name and grade box -->

      <v-row class="pb-3 mr-5 justify-start">
        <v-btn x-small @click="navigateUp" exact class="back-button">
          <v-icon x-small>mdi-arrow-left-circle</v-icon>
          To Wall
        </v-btn>
      </v-row>

      <v-row class="pb-2 justify-center">
        <h3 class="white--text">{{ route.name }} ({{ route.grade }})</h3>
      </v-row>

      <!-- return to wall page button -->
      <v-row class="pb-2 justify-center">
        <!-- <v-btn small v-bind:to="{ name: 'wall', params: '{id: route.wallId}' }"> -->
        <v-cols>
          <!-- Tickbox button -->
          <tick-box class="pr-2" :route="route" />
        </v-cols>
        <!-- add to to-do list button -->
        <v-cols>
          <v-btn x-small v-if="!isHidden" @click="addTodo">
            Wanna ClimbIt
          </v-btn>
        </v-cols>
      </v-row>
      <v-card class="blue"> </v-card>
    </v-container>
  </div>
</template>

<script>
import TickBox from "./TickBox.vue";
import todoService from "../../services/TodoService.js";

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
    navigateUp() {
      this.$router.push({ name: "wall", params: { id: this.route.wallId } });
    },

    addTodo() {
      const newTodo = {
        profileId: this.$store.state.user.id,
        routeId: this.route.id,
      };

      todoService.post(newTodo).then((response) => {
        if (response.status === 201) {
          this.isHidden = true;
          this.$router.push(`${this.route.id}`);
        }
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
.main-body {
  background-color: #f4511e;
  width: 100%;
}
</style>