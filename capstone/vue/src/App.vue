<template>
   <v-app>
     <NavBar></NavBar>
     <!--<image-upload-preview/> -->
    <v-main>

    <router-view />
  
  </v-main>
  
  </v-app> 

</template>

<script>
 import NavBar from "./components/NavBar.vue";
 //import ImageUploadPreview from './components/ImageUploadPreview.vue'
 import Cloudinary from "cloudinary-vue";
 import Vue from 'vue';

 Vue.use(Cloudinary, {
  configuration: { 
    cloudName: "dacyocfmf",
    secure: true }
});



export default {
 
  name: 'App',
  components: {NavBar},  //ImageUploadPreview
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
