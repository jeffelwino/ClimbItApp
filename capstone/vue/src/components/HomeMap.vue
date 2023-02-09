<template>
  <div class="map">
    <h2 class="secondary">Climbs near you!</h2>
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
      :zoom="10"
      id="map"
    >
      <GmapMarker
        v-for="area in areas"
        :key="area.id"
        :position="{
          lat: parseFloat(area.latitude),
          lng: parseFloat(area.longitude),
        }"
        :label="area.name"
        v-on:click="navigateToPage(area.id)"
    /></GmapMap>
  </div>
</template>

<script>
import locationService from "../services/LocationService.js";
export default {
  name: "area-map",

  data() {
    return {
      areas: [],
      center: { lat: 39.92099, lng: -83.81161 },
    };
  },
  created() {
    this.loadAreas();
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
    loadAreas() {
      locationService.loadAreas().then((response) => {
        if (response.status == 200) {
          this.areas = response.data;
        }
      });
    },
    navigateToPage(areaId) {
      if (this.$store.state.token === "") {
        this.$router.push({
          name: "login",
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