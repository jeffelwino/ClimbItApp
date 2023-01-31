<template>
  <div class="map">
    <h2>This is the Map!</h2>
    <GmapMap :center="center" :zoom="12" id="map">
      <GmapMarker
        v-for="marker in markers"
        :key="marker.id"
        :position="marker.position"
    /></GmapMap>
  </div>
</template>

<script>
export default {
  name: "display-map",

  data() {
    return {
      center: { lat: 39.92099, lng: -83.81161 }, //default location, will be overriden
      currentPlace: null,
      markers: [],
      places: [],
    };
  },
  mounted() {
    this.geolocate();
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
      this.$store.areas.forEach((area) => {
        const marker = {
          lat: area.lat,
          lng: area.lng,
        };
        this.markers.push({ position: marker });
      });
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