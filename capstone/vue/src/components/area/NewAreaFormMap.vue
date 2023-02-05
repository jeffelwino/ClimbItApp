<template>
  <div class="crag">
    <h2>Search and add a pin</h2>
    <GmapAutocomplete @place_changed="setPlace" />
    <button @click="addMarker">Add Crag</button>
    <GmapMap
      :center="center"
      :zoom="14"
      style="width: 100%; height: 600px"
      id="crag-map"
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
  name: "crag-map",
  props: ["crag"],
  data() {
    return {
      center: { lat: this.crag.latitude, lng: this.crag.longitude },
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
    addCrags() {
      //This will push the new created crags to the crag store 
      // this.$router.crags.push(this.places) <-- or something like this...
    }
  },
};
</script>

<style>
</style>