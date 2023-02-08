<template>
  <div class="map">
    <h2>Crags in the Area</h2>
    <GmapMap
      :center="center"
      :zoom="10"
      style="width: 100%; height: 600px"
      id="map"
    >
      <div @mouseenter="openMarker(crag.id)">
      <GmapMarker
        v-for="crag in crags"
        :key="crag.id"
        :position="{
          lat: parseFloat(crag.position.lat),
          lng: parseFloat(crag.position.lng),
        }"
        @mouseover="openMarker(crag.id)"
        v-on:click="navigateToPage(crag.id)"
        >
       <GmapInfoWindow
          :closeclick="true"
          @closeclick="openMarker(null)"
          :opened="openedMarkerID === crag.id"> 
          <v-card>{{crag.name}}</v-card>
    </GmapInfoWindow>
    
    </GmapMarker></div></GmapMap>
  </div>
</template>

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
      center: { 
        lat: this.area.latitude, 
        lng: this.area.longitude 
        },
        openedMarkerID: null,
        
    };
  },
  methods: {
        openMarker(id){
          this.openedMarkerID = id;

        },
    navigateToPage(id) {
      this.$router.push({
        name: "crag",
        params: { id: id },
      });
    },
  },
};
</script>

<style>
#map {
  width: 100%;
  height: 400px;
}
</style>