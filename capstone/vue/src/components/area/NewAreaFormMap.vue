<template>
  <div class="new-area-map">
    <h2>Search and add a pin</h2>
    <GmapAutocomplete @place_changed="setPlace" />
    <button @click="addMarker">Add Area</button>
    <GmapMap
      :center="center"
      :zoom="14"
      style="width: 100%; height: 600px"
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
  name: "new-area-map",
  props: ["state", "areas"],
  data() {
    return {
      center: {lat: this.state.latitude, lng: this.state.longitude},
      currentPlace: null,
      markers: [],
      places: [],
    };
  },
  mounted() {
    this.geolocate();
  },
  methods: {
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
    }
  },
};
</script>

<style>
</style>