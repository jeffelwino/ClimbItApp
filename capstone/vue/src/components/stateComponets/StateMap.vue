<template>
  <div class="state-map">
    <GmapMap
      :options="{
        zoomControl: true,
        mapTypeControl: true,
        scaleControl: true,
        streetViewControl: false,
        rotateControl: false,
        fullscreenControl: true,
        disableDefaultUi: false,
        mapTypeId: 'satellite',
      }"
      :center="center"
      :zoom="7"
      style="width: 100%; height: 400px"
      id="state-map"
    >
      <GmapMarker
        v-for="area in areas"
        :key="area.id"
        :position="{ lat: area.latitude, lng: area.longitude }"
        :label="area.name"
        @click="navigateToPage(area.id)"
    /></GmapMap>
  </div>
</template>

<script>
export default {
  name: "state-map",
  props: ["state", "areas"],

  data() {
    return {
      center: { lat: this.state.latitude, lng: this.state.longitude },
    };
  },
  methods: {
    navigateToPage(id) {
      this.$router.push({
        name: "area",
        params: { id: id },
      });
    },
  },
};
</script>

<style>
</style>