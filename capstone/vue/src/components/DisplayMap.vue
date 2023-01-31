<template>
  <div class="map">
    <h2>This is the Map!</h2>
    <GmapMap :center="center" :zoom="12" id="map"> </GmapMap>
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
    setPlace(place) {
      this.currentPlace = place;
    },
    geolocate: function () {
      navigator.geolocation.getCurrentPosition((position) => {
        this.center = {
          lat: position.coords.latitude,
          lng: position.coords.longitude,
        };
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