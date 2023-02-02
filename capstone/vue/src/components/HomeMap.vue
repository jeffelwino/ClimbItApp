<template>
  <div class="map">
    <h2>Climbs near you!</h2>
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
export default {
  name: "display-map",

  data() {
    return {
      center: { lat: 39.92099, lng: -83.81161 }, 
      currentPlace: null,
      markers: [],
      places: [],
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
          id: area.id,
        });
      });
    },
    navigateToPage(areaId) {
        if(this.$store.state.token === ''){
           this.$router.push({
             name: 'login'
             });
        } else {
          this.$router.push({
          name: "area",
          params: { id: areaId },
        });
      }
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