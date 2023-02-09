<template>
  <v-container>
    <v-card class="mx-auto" max-width="700">
      <v-img>
        <cld-context cloudName="dacyocfmf" secure="true">
          <cld-image :publicId="photoId" width="318" height="150" crop="fill" />
          <cld-transformation aspect-ratio="1.5" crop="crop" />
        </cld-context>
      </v-img>

      <v-card-title>
        {{ wall.name }}
      </v-card-title>

      <v-card-actions>
        <v-btn class="green" color="white darken-2" text @click="loadRoute">
          Check out this wall!
        </v-btn>

        <v-spacer></v-spacer>

        <v-btn icon @click="show = !show">
          <v-icon>{{ show ? "mdi-chevron-up" : "mdi-chevron-down" }}</v-icon>
        </v-btn>
      </v-card-actions>

      <v-expand-transition>
        <div v-show="show">
          <v-divider></v-divider>

          <v-card-text>
            {{ wall.description }}
          </v-card-text>
        </div>
      </v-expand-transition>
    </v-card>
  </v-container>
</template>

<script>
import imageService from "../../services/ImageService.js";

export default {
  name: "wall-card",
  props: ["wall"],
  data: () => ({
    show: false,
    photos: [],
    photoId: "",
  }),
  methods: {
    loadRoute() {
      this.$router.push({ name: "wall", params: { id: this.wall.id } });
    },
  },
  created() {
    imageService.getPhotosByWallId(this.wall.id).then((response) => {
      if (response.status == 200) {
        this.photos = response.data;
        let index = Math.floor(Math.random() * this.photos.length);
        this.photoId = this.photos[index].photoId;
      }
    });
  },
};
</script>

<style>
</style>