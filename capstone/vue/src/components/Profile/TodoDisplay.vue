<template>
  <div class="todo">
    <h4>-{{ route.name }}</h4>
  </div>
</template>

<script>
export default {
  name: "todo-display",

  props: ["todo"],
  computed: {
    route() {
      return this.$store.state.routes.find((r) => {
        return r.id == this.todo;
      });
    },
  },
};
</script>

<style>
</style>