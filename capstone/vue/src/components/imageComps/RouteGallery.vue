<template>
  <div>
    <v-card class="mx-7 mt-5"  >
      <v-carousel hide-delimiters  height="auto">
    <v-carousel-item
      v-for="(item,i) in items"
      :key="i"
      
    > <v-img :src="item.src" contain max-height="400"></v-img> </v-carousel-item>
  </v-carousel>
    </v-card>
  </div>
</template>

<script>
export default {
  name: "route-gallery",
  data() {
    return {
      items: [
        {
          src: "https://mountainproject.com/assets/photos/climb/117828911_medium_1570200281_topo.jpg?cache=1574302555",
        },
        {
          src: "https://mountainproject.com/assets/photos/climb/119347433_medium_1596911470.jpg?cache=1596925685",
        },
        {
          src: "https://mountainproject.com/assets/photos/climb/114307337_medium_1524928496.jpg?cache=1547922424",
        },
        {
          src: "https://cdn.vuetifyjs.com/images/carousel/planet.jpg",
        },
      ],
    };
  },
};
</script>

<style>
</style>