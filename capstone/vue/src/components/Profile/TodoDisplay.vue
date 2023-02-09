<template>
  <div class="jjj">
    <v-card outlined class="todo">
      <h5 @click.prevent="navigateToPage">{{ route.name }}</h5>
      <v-spacer></v-spacer>
      <v-btn icon right @click="deleteTodo">X</v-btn>
    </v-card>
  </div>
</template>

<script>
import locationService from "../../services/LocationService.js";
import todoService from "../../services/TodoService.js";
export default {
  name: "todo-display",
  props: ["todo"],
  data() {
    return {
      route: {},
    };
  },

  methods: {
    navigateToPage() {
      this.$router.push({
        name: "route-page",
        params: { id: this.route.id },
      });
    },
    deleteTodo() {
      todoService.delete(this.todo.todoId).then((response) => {
        if (response.status == 204) {
          this.$router.go(0);
        }
      });
    },
  },
  created() {
    locationService.getRouteById(this.todo.routeId).then((response) => {
      if (response.status == 200) {
        this.route = response.data;
      }
    });
  },
};
</script>

<style scoped>
.todo {
  display: flex;
  /* justify-content: space-evenly; */
}
</style>