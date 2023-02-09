<template>
  <div class="state-map">
    <!-- :options="{
        zoomControl: true,
        mapTypeControl: true,
        scaleControl: true,
        streetViewControl: false,
        rotateControl: false,
        fullscreenControl: true,
        disableDefaultUi: false,
      }" -->
    <GmapMap
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
        @click="openMarker(area.id)"
      >
        <GmapInfoWindow
          :closeclick="true"
          @closeclick="openMarker(null)"
          :opened="openedMarkerID === area.id"
          :options="{
            pixelOffset: {
              width: 10,
              height: 0,
            },
            maxWidth: 150,
            maxHeight: 320,
          }"
        >
          <div @click.stop="navigateToPage(area.id)">
            {{ area.name }}
            <v-divider></v-divider>
            {{ area.description }}
          </div>
        </GmapInfoWindow>
      </GmapMarker>
    </GmapMap>
  </div>
</template>

<script>
import locationService from "../../services/LocationService.js";
export default {
  name: "state-map",
  data() {
    return {
      state: {},
      areas: [],
      center: {
        lat: "",
        lng: "",
      },
      openedMarkerID: null,
    };
  },
  // computed: {
  //   state() {
  //     return this.$store.state.activeState;
  //   },
  //   areas() {
  //     return this.$store.state.activeAreas;
  //   },
  // },
  methods: {
    openMarker(id) {
      this.openedMarkerID = id;
    },
    navigateToPage(id) {
      this.$router.push({
        name: "area",
        params: { id: id },
      });
    },
  },
  created() {
    locationService
      .getStateByAbbrev(this.$route.params.abbrev)
      .then((response) => {
        if (response.status == 200) {
          this.state = response.data;
          // this.$store.commit("SET_ACTIVE_STATE", response.data);
          this.center.lat = parseFloat(this.state.latitude);
          this.center.lng = parseFloat(this.state.longitude);
          locationService
            .getAreasByState(this.state.abbrev)
            .then((response) => {
              console.log(response);
              if (response.status == 200) {
                this.areas = response.data;
                // this.$store.commit("SET_ACTIVE_AREAS", response.data);
              }
            });
        }
      });
  },
};
</script>

<style>
</style>