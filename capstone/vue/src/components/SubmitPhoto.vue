<template>
  <v-card>
      <v-card-text>
        <v-img 
            :src="image ? imagePreview : 'https://picsum.photos/id/11/500/300'"
            lazy-src="https://picsum.photos/id/11/10/6"
            height="30vh"    
         ></v-img>
            <v-file-input
                v-model="image"
                outlined 
                clearable
                truncate-length="15"
                multiple
                accept="image/png, image/jpeg, image/bmp"
                label= "Select your photo(s)"
                prepend-icon="mdi-camera"
                @change="onFileSelected"
            ></v-file-input>
        <v-btn @click="onUpload">Upload</v-btn>
      </v-card-text>
  </v-card>
</template>

<script>
export default {
    name: "submit-photo",
    data(){
        return {
            selectedFile: null,
        }
    },
    methods: {
       onFileSelected(event){
           this.selectedFile = event.target.files[0];
       },
       onUpload(){
           
       }
    }

}
</script>

<style>

</style>