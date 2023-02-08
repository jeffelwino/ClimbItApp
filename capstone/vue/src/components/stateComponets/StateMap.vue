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
      }"
      :center="center"
      :zoom="7"
      style="width: 100%; height: 400px"
      id="state-map"
    >
      <GmapMarker
        v-for="area in areas"
        :key="area.id"
        :position="{
          lat: parseFloat(area.latitude),
          lng: parseFloat(area.longitude),
        }"
        :label="area.name"
        @click="navigateToPage(area.id)"
    /></GmapMap>
  </div>
</template>

<script>
import locationService from "../../services/LocationService.js";
export default {
  name: "state-map",
  // props: ["state", "areas"],

  data() {
    return {
      state: {},
      areas: {},
      center: {
        lat: parseFloat(this.state.latitude),
        lng: parseFloat(this.state.longitude),
      },
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
  beforeCreate() {
    locationService
      .getStateByAbbrev(this.$route.params.abbrev)
      .then((response) => {
        if (response.status == 200) {
          console.log("state:");
          console.log(response.data);
          this.state = response.data;
        }
      });
  },
  created() {
    locationService.getAreasByState(this.state.abbrev).then((response) => {
      // console.log(response);
      if (response.status == 200) {
        console.log("areas:");
        console.log(response.data);
        this.areas = response.data;
      }
    });
  },
};
</script>

<style>
</style>