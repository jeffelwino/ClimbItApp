<template>
  <v-container>
    <div class="todo">
      <h3>{{ profile.name }}'s WannaClimb List:</h3>
      <v-card>
        <todo-display v-for="todo in todos" :key="todo.id" :todo="todo" />
      </v-card>
    </div>
  </v-container>
</template>

<script>
import TodoDisplay from "./TodoDisplay.vue";
import todoService from "../../services/TodoService.js";
export default {
  components: { TodoDisplay },
  name: "profile-todo",
  props: ["profile"],
  data() {
    return {
      todos: [],
    };
  },
  created() {
    todoService.listByProfile(this.$route.params.id).then((response) => {
      if (response.status == 200) {
        this.todos = response.data;
      }
    });
  },
};
</script>

<style>
</style>