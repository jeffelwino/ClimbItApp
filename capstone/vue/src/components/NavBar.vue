<template>
    <v-app-bar
      app
      color="blue"
      dark
    >
    <v-row align-items="center">
    <v-icon large>mdi-spa</v-icon>
    <v-toolbar-title class="ml-5"> <h2>ClimbIt</h2> </v-toolbar-title>

    <v-spacer></v-spacer>

    <v-btn icon> <v-icon>mdi-magnify</v-icon></v-btn>

  
    
        <!-- <v-text-field 
        solo
        label="search routes"
        append-inner-icon="mdi-search"
        ></v-text-field> -->

        <v-app-bar-nav-icon large></v-app-bar-nav-icon>
    


    

      <!-- <div class="d-flex align-center">
        <v-img
          alt="Vuetify Logo"
          class="shrink mr-2"
          contain
          src="https://cdn.vuetifyjs.com/images/logos/vuetify-logo-dark.png"
          transition="scale-transition"
          width="40"
        />

        <v-img
          alt="Vuetify Name"
          class="shrink mt-1 hidden-sm-and-down"
          contain
          min-width="100"
          src="https://cdn.vuetifyjs.com/images/logos/vuetify-name-dark.png"
          width="100"
        />
      </div>

      <v-spacer></v-spacer>

      <v-btn
        href="https://github.com/vuetifyjs/vuetify/releases/latest"
        target="_blank"
        text
      >
        <span class="mr-2">Latest Release</span>
        <v-icon>mdi-open-in-new</v-icon>
      </v-btn> -->
      </v-row>
    </v-app-bar>
</template>

<script>
export default {
    name: "navbar",

}
</script>

<style>

</style>