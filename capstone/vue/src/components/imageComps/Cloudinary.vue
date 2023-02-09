<template>
  <v-container>
      <v-btn v-if="this.$store.state.user.id == this.$route.params.id" v-on:click="upload">Upload your profile picture</v-btn><br>
  </v-container>
</template>

<script>
import imageService from "../../services/ImageService.js"
export default {
  props: ["profile"],
  name: 'cloudinary-comp',

  data() {
    return {
      myWidget : {}
    }
  },

  methods: {
      upload() {
        this.myWidget.open();
      }
  },
  mounted() {
       this.myWidget = window.cloudinary.createUploadWidget(
      {
        // Insert your cloud name and presets here, 
        // see the documentation
        cloudName: 'dacyocfmf',
        uploadPreset: 'dshjquno'
      }, 
      (error, result) => { 
        if (!error && result && result.event === "success") { 
          console.log('Done! Here is the image info: ', result.info); 
          console.log("Image URL: " + result.info.url);
          console.log("This is the public id: " + result.info.public_id);
          // this.$store.commit("UPDATE_PROFILE_PIC", {profileId:this.$store.state.user.id, picture:result.info.public_id})
          imageService.updateProfilePicture({profileId:this.$route.params.id, photoId:result.info.public_id}).then(response => {
            if(response.status == 200){
              this.$router.go(0);
            } else{
              window.alert("Something Went wrong!!")
            }
          })
        }
      })        
  }
}



</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>