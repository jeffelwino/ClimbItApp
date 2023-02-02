<template>
  <v-container>
    <v-row justify="center">
      <v-dialog scrollable max-width="300px">
        <template v-slot:activator="{ on, attrs }">
          <v-btn color="primary" dark v-bind="attrs" v-on="on">
            Search Climbing By State
          </v-btn>
        </template>
        <v-card>
          <v-list-item
            v-for="state in $store.state.states"
            v-bind:key="state.name"
            @click="goToStatePage(state.abbrev)"
          >
            <!-- <router-link
              v-bind:to="{
                name: 'state-page',
                params: { abbrev: state.abbrev },
              }"> -->
              {{ state.name }}
              <!-- </router-link> -->
          </v-list-item>
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