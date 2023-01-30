<template>
  <div class="map">
    <h2>This is the Map!</h2>
    <div id="map"></div>
  </div>
</template>

<script>
export default {
  name: "display-map",

  data() {
    return {
      map: null,
      mapCenter: { lat: 39.92099, lng: -83.81161 }, //the location of the user
      locations: [{ coord: { lat: 39.91448, lng: -83.85988 }, name: "MRG" }],
    };
  },
  methods: {
    initMap() {
      this.calculateCenter();
      this.map = new window.google.maps.Map(document.getElementById("map"), {
        center: this.mapCenter,
        zoom: 14,
        maxZoom: 20,
        minZoom: 3,
        streetViewControl: true,
        mapTypeControl: true,
        fullscreenControl: true,
        zoomControl: true,
      });
      let noPOIStyle = [
        {
          featureType: "poi",
          elementType: "labels",
          stylers: [{ visibility: "off" }],
        },
      ];
      this.map.setOptions({ styles: noPOIStyle });
      window.google.maps.event.addListener(this.map, "rightclick", (event) => {
        this.addPinViaClick(event);
      });
    },
    calculateCenter() {
      let latTotal = 0,
        lngTotal = 0;
      for (let i = 0; i < this.locations.length; i++) {
        latTotal += parseFloat(this.locations[i].coord.lat);
        lngTotal += parseFloat(this.locations[i].coord.lng);
      }
      const lat = latTotal / this.locations.length;
      const lng = lngTotal / this.locations.length;
      this.mapCenter = { lat: lat, lng: lng };
    },
    makeMarkerObj(latLng, name) {
      const markerObj = { coord: latLng, name: name };
      return markerObj;
    },
    dropPins() {
      this.locations.forEach((x) => this.dropPin(x));
    },
    dropPin(markerObj) {
      new window.google.maps.Marker({
        position: markerObj.coord,
        map: this.map,
        label: {
          text: markerObj.name,
          color: "blue",
        },
      });
    },
    mounted() {
    this.initMap();
    this.dropPins();
  },
  },
};
</script>

<style>
#map {
  /* grid-area: map; */
  width: 500px;
  height: 400px;
  padding: 25px;
  margin: 25px;
}
</style>