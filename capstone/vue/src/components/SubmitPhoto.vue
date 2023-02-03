<template>
  <v-container>
        <v-file-input
            outlined 
            clearable
            truncate-length="15"
            chips
            multiple
            accept="image/*"
            label= "Select your photo(s)"
            prepend-icon="mdi-camera"
        ></v-file-input>
      <v-btn @click="uploadPhotos">Submit 'em</v-btn>
  </v-container>
</template>

<script>
export default {
    data(){
        return {
            image: ""
        }
    },
  components: { },
  methods: {
        uploadPhotos(){
            
        }
    }

}
</script>

<style>

</style>