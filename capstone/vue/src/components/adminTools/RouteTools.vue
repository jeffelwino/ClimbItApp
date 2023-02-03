<template>
  <div>
      <v-sheet color="red">
          <h1>Admin TOOL BAR</h1>
          <v-btn> Delete Route</v-btn>
      </v-sheet>
  </div>
</template>

<script>
export default {
    name: 'route-tools',
    computed: {
        routePage(){
            return this.$store.state.routes.find(r => {
                return r.id == this.$route.params.id;
            });
        }
    },
    methods: {
        // deleteRoutePage(id){

        // }
    }

}
</script>

<style>

</style>