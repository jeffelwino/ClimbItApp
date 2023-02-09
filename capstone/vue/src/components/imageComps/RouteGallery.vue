<template>
  <div class="text-center">
    <v-card class="mx-3 mt-5">
      <v-carousel hide-delimiters height="400">
        <v-carousel-item v-for="(photo, i) in photos" :key="i">
          <cld-context cloudName="dacyocfmf" secure="true">
            <cld-image :publicId="photo.photoId" contain />
            <!-- <v-img :src="item.src" contain max-height="400"></v-img>  -->
          </cld-context>
        </v-carousel-item>
      </v-carousel>
      <upload-route-image />
    </v-card>
  </div>
</template>

<script>
import UploadRouteImage from "./UploadRouteImage.vue";
import imageService from "../../services/ImageService.js";

export default {
  components: { UploadRouteImage },
  props: ["route"],
  name: "route-gallery",
  data() {
    return {
      photos: [],
    };
  },
  created() {
    imageService.getPhotosByRoute(this.$route.params.id).then((response) => {
      if (response.status == 200) {
        this.photos = response.data;
      }
    });
  },
};
</script>

<style>
</style>