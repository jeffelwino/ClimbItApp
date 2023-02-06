<template>
  <div>
      <h2>User Profile!</h2>
      
      <cld-image cloudName="dacyocfmf" publicId="ssu0yraojylulspeeuhv" width="300" crop="scale" />
     

  </div>

</template>

<script>
import Vue from 'vue';
import Cloudinary from "cloudinary-vue";

// Vue.use(Cloudinary, {
//   configuration: { cloudName: "demo" },
//   components: {
//     CldContext,
//     CldImage, 
//     CldVideo, 
//     CldTransformation,
//   }
// });

Vue.use(Cloudinary, {
  configuration: { 
    cloudName: "dacyocfmf",
    secure: true }
});



export default {

}
</script>

<style scoped>

.picture{
  border: 2px solid black;
  height: 50px;
  width: 50px;

}

</style>