<template>
  <v-card>
    <v-card-text>
      <v-img src='result.info.url'></v-img>
      <h2>Click below to submit your photos for route</h2>
      <v-btn v-on:click="upload">Upload</v-btn><br>
    </v-card-text>  
  </v-card>
</template>

<script>
export default {
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
        }
      }
    );
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