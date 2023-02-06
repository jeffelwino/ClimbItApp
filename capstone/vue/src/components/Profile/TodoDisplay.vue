<template>
  <div class="todo">
    <v-card outlined @click.prevent="navigateToPage">
    <h5>{{ route.name }}</h5>
    </v-card>
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
  methods: {
      navigateToPage() {
     
        this.$router.push({
          name: "route-page",
          params: { id: this.route.id },
        });
      
    },
  }
  
};
</script>

<style>
</style>