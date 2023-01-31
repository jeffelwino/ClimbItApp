<template>
  <div class="map">
    <h2>This is the Map!</h2>
    <GmapMap :center = "mapCenter" :zoom = "12" id="map" />
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
  
   }
}
</script>

<style>
#map {
  width: 100%;
  height: 400px;
}
</style>