<template>
  <div class="map">
    <h2>Crags in the Area</h2>
    <GmapMap :center="center" :zoom="10" style="width:100%; height:600px;" id="map">
      <GmapMarker
        v-for="crag in crags"
        :key="crag.id"
        :position="crag.position"
        :label="crag.name"
        v-on:click="navigateToPage(crag.id)"
    /></GmapMap>
  </div>
</template>

<script>

//import AreaDetail from './components/AreaDetail.vue'
export default {
  name: "display-map",

  data() {
    return {
      center: { lat: 39.92099, lng: -83.81161 }, // this.$store.state.areas{id: {area.id}}....needs to be on whatever the area clicked on is 
      currentPlace: null,
      markers: [],
      places: [],
      areas: [],
      crags: [],
    };
  },
  mounted() {
    this.geolocate();
    this, this.getCrags();
  },
  methods: {
    geolocate: function () {
      navigator.geolocation.getCurrentPosition((position) => {
        this.center = {
          lat: position.coords.latitude,
          lng: position.coords.longitude,
        };
      });
    },
    loadPlaces() {
      this.$store.state.areas.forEach((area) => {
        const marker = {
          lat: area.latitude,
          lng: area.longitude,
        };
        this.markers.push({
          position: marker,
          name: area.name,
          id: area.area_name,
        });
      });
    },
    navigateToPage(id) {
      this.$router.push({
        name: "test",
        params: { id: id },
      });
    },
    getCrags() {
      //To limit our zoom window
      //I need to make a method where I search through the array of areas
      //and using the id I pull up all of the crags in that spot
      //
      //then set my zoom window to the number of markers I have
      //I have the methods but how do I implement them??
      

      this.$store.state.crags.forEach((crag) => {
        const cragMarker = {
          lat: crag.latitude,
          lng: crag.longitude,
        };
        this.crags.push({
          position: cragMarker,
          name: crag.name,
          id: crag.id,
        });
      });
    },
    fitBounds() {
      //This method needs to be able to set the boundaries of the map to just fit in all of the markers
    },
  },
};
</script>

<style>
#map {
  width: 100%;
  height: 400px;
}
</style>