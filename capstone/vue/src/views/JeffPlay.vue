<template>
  <div class="map">
    <h2>Crags in the Area</h2>
    <GmapMap
      :center="center"
      :zoom="10"
      style="width: 100%; height: 600px"
      id="map"
    >
      <GmapMarker
        v-for="crag in crags"
        :key="crag.id"
        :position="{
          lat: parseFloat(crag.position.lat),
          lng: parseFloat(crag.position.lng),
        }"
        :label="crag.name"
        v-on:click="navigateToPage(crag.id)"
    /></GmapMap>
  </div>
</template>

 methods: {
          toggleInfoWindow: function(marker, idx) {
            this.infoWindowPos = marker.position;
            this.infoOptions.content = marker.infoText;

            //check if its the same marker that was selected if yes toggle
            if (this.currentMidx == idx) {
              this.infoWinOpen = !this.infoWinOpen;
            }

            //if different marker set infowindow to open and reset current marker index
            else {
              this.infoWinOpen = true;
              this.currentMidx = idx;
            }
          }
        }

<script>
//import AreaDetail from './components/AreaDetail.vue'
export default {
  name: "area-map",
  props: ["area"], //This variable holds whatever is in the area detail
  computed: {
    crags() {
      return this.$store.state.crags.filter((crag) => {
        return crag.areaId == this.area.id;
      });
    },
  },
  data() {
    return {
      center: { lat: this.area.latitude, lng: this.area.longitude }, // this.$store.state.areas{id: {area.id}}....needs to be on whatever the area clicked on is
      // currentPlace: null,
      // markers: [],
      // places: [],
      // areas: [],
      // crags: [],
    };
  },
  mounted() {
    // this.getCrags();
  },
  methods: {
    // loadPlaces() {
    //   this.$store.state.areas.forEach((area) => {
    //     const marker = {
    //       lat: area.latitude,
    //       lng: area.longitude,
    //     };
    //     this.markers.push({
    //       position: marker,
    //       name: area.name,
    //       id: area.area_name,
    //     });
    //   });
    // },
    navigateToPage(id) {
      this.$router.push({
        name: "crag",
        params: { id: id },
      });
    },
    //To-do: move to Area.vue
    // getCrags() {
    //   this.$store.state.crags.forEach((crag) => {
    //     const cragMarker = {
    //       lat: crag.latitude,
    //       lng: crag.longitude,
    //     };
    //     this.crags.push({
    //       position: cragMarker,
    //       name: crag.name,
    //       id: crag.id,
    //     });
    //   });
    // },
  },
};
</script>

<style>
#map {
  width: 100%;
  height: 400px;
}
</style>