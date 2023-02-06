<template>
<v-container>
  <div class="todo">
    <h3>{{ profile.name }}'s WannaClimb List:</h3>
    <v-card>
    <todo-display v-for="todo in profile.todos" :key="todo.id" :todo="todo" />
    </v-card>
  </div>
  </v-container>
</template>

<script>
import TodoDisplay from "./TodoDisplay.vue";
export default {
  components: { TodoDisplay },
  name: "todo",
  props: ["profile"],
};
</script>

<style>
</style>