<template>
  <div class="map">
    <h2>This is the Map!</h2>
    <GmapMap :center="center" :zoom="10" id="map">
      <GmapMarker
        v-for="marker in markers"
        :key="marker.id"
        :position="marker.position"
        :label="marker.name"
        v-on:click="navigateToPage(marker.id)"
    /></GmapMap>
  </div>
</template>

<script>
//import Area from './views/Area.vue'

export default {
  name: "display-map",

  data() {
    return {
      center: { lat: 39.92099, lng: -83.81161 }, //default location, will be overriden
      currentPlace: null,
      markers: [],
      places: [],
      areas: [],
      crags: []
    };
  },
  mounted() {
    this.geolocate();
    this, this.loadPlaces();
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
     getBounds(){ //To limit our zoom window 
         //I need to make a method where I search through the array of areas
         //and using the id I pull up all of the crags in that spot
         //
         //then set my zoom window to the number of markers I have
         //I have the methods but how do I implement them??
         //let areaMarkers = this.$store.state.areas.id;
         /*this.$store.state.areas.forEach( (area) => {
            const crag = {} })
         */
        
    },
    fitBounds(){
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