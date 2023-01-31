<template>
<div>
    <div>
<h2>{{state.name}}</h2>
    </div>
    

    <!-- mapdisplay placeholder-->
    <div class="placeholdermap">
        <h2 >This will be a map</h2>
    </div>

    <!-- List of climbing areas in state w/ ratings -->
 <!-- <v-card>
        <v-list-item
          v-for="state in $store.state.states"
          v-bind:key="state.name"
        > 
        <router-link v-bind:to="{name: 'state-detail', params: {abbrev: state.abbrev}}">{{ state.name }}</router-link>
        </v-list-item>
        </v-card> -->





</div>
  
</template>

<script>
export default {
    name: 'state-info',
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

}
</script>

<style scoped>

h2{
    text-align: center;
}
.placeholdermap{
    margin-top: 5%;
   background-color: red;
   width: 90%;
   height: 20rem;
   margin-left: 5%;
   border: 1px solid black;
   text-align: center;
}

</style>