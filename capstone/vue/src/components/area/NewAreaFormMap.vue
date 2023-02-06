<template>
  <div class="new-area-form-map">
    <h2>Search and add a pin</h2>
    <GmapAutocomplete @place_changed="setPlace" />
    <button @click.prevent="addMarker">Add Area</button>
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
      :zoom="7"
      style="width: 100%; height: 400px"
      id="area-map"
    >
      <GmapMarker
        :key="index"
        v-for="(m, index) in markers"
        :position="m.position"
        @click="center = m.position"
    /></GmapMap>
  </div>
</template>

<script>
export default {
  name: "new-area-form-map",
  props: ["state", "areas"],
  data() {
    return {
      center: { lat: this.state.latitude, lng: this.state.longitude },
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
    addMarker() {
      if (this.currentPLace) {
        const marker = {
          lat: this.currentPlace.geometry.location.lat(),
          lng: this.currentPlace.geometry.location.lng(),
        };
        this.markers.push({ position: marker });
        this.places.push(this.currentPlace);
        this.center = marker;
        this.currentPlace = null;
      }
    },
    geolocate: function () {
      navigator.geolocation.getCurrentPosition((position) => {
        this.center = {
          lat: position.coords.latitude,
          lng: position.coords.longitude,
        };
      });
    },
    addArea() {
      //This will push the new created crags to the crag store
      // this.$router.area.push(this.places) <-- or something like this...
    },
  },
};
</script>

<style>
</style>