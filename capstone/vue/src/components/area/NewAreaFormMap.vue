<template>
  <div class="new-area-form-map">
    <h2>Search and add a pin</h2>
    <!-- <GmapAutocomplete @place_changed="setPlace" /> -->
    <button @click.prevent="addMarker">Add Area</button>
    <GmapMap
      :center="mapCenter"
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
      map: null,
      mapCenter: { lat: this.state.latitude, lng: this.state.longitude },
      currentPlace: null,
      markers: [],
      places: [],
    };
  },
  mounted() {
    this.geolocate();
  },
  methods: {
   initMap() {

      this.map = new window.google.maps.Map(document.getElementId("map"), {
        center: this.mapCenter,
        zoom: 7,
        maxZoom: 20,
        minZoom: 6,
        zoomControl: true,
        mapTypeControl: true,
        streetViewControl: true,
        fullscreenControl: true,
      });

        let noPOIStyle = [{
          featureType: "poi",
          elementType: "labels",
          stylers: [{ visibility: "off"}],
        }];
        this.map.setOptions({ styles: noPOIStyle});
        window.google.maps.event.addListener(this.map, "rightclick", (event) => {this.addPinViaClick(event);
      });

    },

    makeMarkerObj(latLng, name) {
      const markerObj = {coord: latLng, name: name};
      return markerObj;
    },

    addPinViaClick(event) {
      let description = window.prompt("Enter a Description");
      const markerObj = this.makeMarkerObj(event.latLng.toJSON(), description);
      this.places.push(markerObj);
      this.dropPin(markerObj);
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