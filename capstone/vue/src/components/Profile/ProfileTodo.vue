<template>
  <div class="todo">
    <h3>Here is {{ profile.name }}'s to-do list:</h3>
    <todo-display v-for="todo in profile.todos" :key="todo.id" :todo="todo" />
  </div>
</template>

<script>
import TodoDisplay from "./TodoDisplay.vue";
export default {
  components: { TodoDisplay },
  name: "todo",
  props: ["profile"],
  data() {
    return {
      //     todos: [
      //       {
      //         profile_id: 1,
      //         routeId: 12,
      //       },
      //       {
      //         profile_id: 1,
      //         routeId: 5,
      //       },
      //       {
      //         profile_id: 1,
      //         routeId: 3,
      //       },
      //     ],
    };
  },
  computed: {},
};
</script>

<style>
</style>