<template>
   <v-app>
     <NavBar></NavBar>
    <v-main>

    <router-view />
  
  </v-main>
  
  </v-app> 

</template>

<script>
 import NavBar from "./components/NavBar.vue";
 import Cloudinary from "cloudinary-vue";
 import Vue from 'vue';

 Vue.use(Cloudinary, {
  configuration: { 
    cloudName: "dacyocfmf",
    secure: true }
});



export default {
 
  name: 'App',
  components: {NavBar},
  data: () => ({
    
  }),
}
</script>

<style>

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
