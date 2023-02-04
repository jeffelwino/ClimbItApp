<template>
  <v-container>
    <v-row justify="center">
      <v-dialog scrollable max-width="500px">
        <template v-slot:activator="{ on, attrs }">
          <v-btn color="primary" dark v-bind="attrs" v-on="on">
            Search Climbing By State
          </v-btn>
        </template>
        <v-card class="d-flex flex-wrap px-3">
    
          <v-flex-item>
          <v-chip class="blue white--text ma-2"             
          v-for="state in $store.state.states"
            v-bind:key="state.name"
            @click="goToStatePage(state.abbrev)">
            {{ state.name }}
          </v-chip>
          </v-flex-item>


            <!-- <router-link
              v-bind:to="{
                name: 'state-page',
                params: { abbrev: state.abbrev },
              }"> -->
              
              <!-- </router-link> -->
        
        </v-card>
      </v-dialog>
    </v-row>


  </v-container>
</template>

<script>
export default {
  name: "state-list",
  methods: {
    // if user is loggedIn, goes to state-page. else, goes to login page
    goToStatePage(abbrev){
        if(this.$store.state.token === ''){
           this.$router.push({
             name: 'login'
             });
        } else{
            this.$router.push({
            name: "state-page",
            params: { abbrev: abbrev },
        });
        }
    }
  }
};
</script>

<style>
</style>