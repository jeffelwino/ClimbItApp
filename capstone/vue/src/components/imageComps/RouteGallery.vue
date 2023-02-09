<template>
  <div class="text-center">
    <v-card class="mx-7 mt-5">
      <v-carousel hide-delimiters height="400">
        <v-carousel-item v-for="(photo, i) in photos" :key="i">
          <cld-context cloudName="dacyocfmf" secure="true">
            <cld-image :publicId="photo.photoId" />
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
      // items: [
      //   {
      //     src: "https://mountainproject.com/assets/photos/climb/117828911_medium_1570200281_topo.jpg?cache=1574302555",
      //   },
      //   {
      //     src: "https://mountainproject.com/assets/photos/climb/119347433_medium_1596911470.jpg?cache=1596925685",
      //   },
      //   {
      //     src: "https://mountainproject.com/assets/photos/climb/114307337_medium_1524928496.jpg?cache=1547922424",
      //   },
      //   {
      //     src: "https://cdn.vuetifyjs.com/images/carousel/planet.jpg",
      //   },
      //],
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