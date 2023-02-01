<template>
  <div class="state-map">
    <GmapMap
      :center="center"
      :zoom="10"
      style="width: 100%; height: 600px"
      id="state-map"
    >
      <GmapMarker :position="center" :label="state.name"
    /></GmapMap>
  </div>
</template>

<script>
export default {
    name: "state-map",
    props: ["state"],
    data() {
        return {
            center: {lat: this.state.latitude, lng: this.state.longitude}
        }
    }
};
</script>

<style>
</style>