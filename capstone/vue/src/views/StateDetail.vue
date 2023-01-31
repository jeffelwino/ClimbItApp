<template>
  <div>
      <h2>Welcome To {{state.name}}</h2>
      <p>We have {{state.areas}} climbing areas</p>
  </div>
</template>

<script>
export default {
    name: 'state-detail',
    data() {
        return{
            state: {
                abbrev: '',
                name: '',
                areas: 0
            }

        };
    },
    methods:
    {
        loadState() {
            this.state = this.$store.state.states.find((estado) => {
                return estado.abbrev == this.$route.params.abbrev;
            });
        },
    },
created() {
    this.loadState();
}
};
    



</script>

<style>

</style>