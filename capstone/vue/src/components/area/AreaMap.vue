<template>
  <div class="map">
    <h2>Crags in the Area</h2>
    <!-- <GmapAutocomplete
    @place_changed='setPlace'/> -->
    <GmapMap
      :options="{
        zoomControl: true,
        mapTypeControl: true,
        scaleControl: true,
        streetViewControl: false,
        rotateControl: false,
        fullscreenControl: true,
        disableDefaultUi: false, 
      }"
      :center="center"
      :zoom="9"
      style="width: 100%; height: 400px"
      id="map"
    >
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
  props: ["area"], //This variable holds whatever is in the area detail
  data() {
    return {
      center: { lat: this.area.latitude, lng: this.area.longitude }, // this.$store.state.areas{id: {area.id}}....needs to be on whatever the area clicked on is
      currentPlace: null,
      markers: [],
      places: [],
      areas: [],
      crags: [],
    };
  },
  mounted() {
     this.geolocate();
    //this.getCrags();
  },
  methods: {

    // setPlace(place) {
    //   this.currentPlace = place;
    // },

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
        name: "crag",
        params: { id: id },
      });
    },
    //To-do: move to Area.vue
    getCrags() {
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
    // fitBounds() {
    //   //This method needs to be able to set the boundaries of the map to just fit in all of the markers
    // },
  },
};
</script>

<style>
#map {
  width: 100%;
  height: 400px;
}
</style>