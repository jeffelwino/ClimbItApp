<template>
    <v-app-bar
      app
      color="blue"
      dark
    >
    <v-row align-items="center">
    <v-icon large>mdi-spa</v-icon>
    <!-- <v-img src="../assets\climbit-logo-v4.png"></v-img> -->
    <v-toolbar-title class="ml-5"> <h2 @click="goToHome">ClimbIt</h2> </v-toolbar-title>

    <v-spacer></v-spacer>

    <v-btn icon> <v-icon>mdi-magnify</v-icon></v-btn>

  <!-- pop-out nav menu -->
      <v-menu transition="scroll-y-transition">
        <template v-slot:activator="{ on, attrs }">
        <v-app-bar-nav-icon large
            v-bind="attrs"
            v-on="on">

        </v-app-bar-nav-icon>
        </template>
         <v-list color="green">
          <v-list-item exact @click="goToProfile"
            >
            <v-list-item-title >View Profile</v-list-item-title>
          </v-list-item>
          <v-divider></v-divider>
            <v-list-item
            link>
            <v-list-item-title>Search Routes</v-list-item-title>
          </v-list-item>
          <v-divider></v-divider>
            <v-list-item exact @click="goToLogout">
            
            <v-list-item-title >LogOut</v-list-item-title>
          </v-list-item>

        </v-list>
      </v-menu> 


      </v-row>
    </v-app-bar>
</template>

<script>
export default {
    name: "navbar",
    methods: {
      goToProfile(){
        this.$router.push({name: 'profile'});
      },
        goToLogout(){
        this.$router.push({name: 'logout'});
      },
        goToHome(){
        this.$router.push({name: 'home'});
      },

    }

}
</script>

<style>

</style>