<template>
  <div class="crag">
    <GmapMap
      :center="center"
      :zoom="14"
      style="width: 100%; height: 600px"
      id="crag-map"
    >
      <GmapMarker :position="center" :label="crag.name"
    /></GmapMap>
  </div>
</template>

<script>
export default {
  name: "crag-map",
  props: ["crag"],
  data() {
      return {
          center: {lat: this.crag.latitude, lng: this.crag.longitude}
      }
  },
};
</script>

<style>
</style>