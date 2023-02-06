<template>
  <div class="new-area-form-map">
    <div id="map-header">
      <GmapAutocomplete @place_changed="setPlace" id="search-bar" />
      
      <!-- <input v-on:click="addPinViaInput" type="button" value="Add Marker" /> -->
     
       <!-- <div id="latitude" class ='coord-input'>
        <span>Latitude:</span><br />
        <input id="latitude-input" type="text" /><br />
        <select id="latitude-direction">
          <option>North</option>
          <option>South</option></select
        ><br />
      </div>

      <div id="longitude" class ='coord-input'>
        <span>Longitude:</span><br />
        <input id="longitude-input" type="text" /><br />
        <select id="longitude-direction">
          <option>West</option>
          <option>East</option>
        </select>
        <br />
         <div id="description" class ='coord-input'>
        <span class="menu-label">Description</span><br />
        <input id="description-input" type="text" /><br />
      </div>
      </div> -->
    </div>
    <GmapMap
      :center="mapCenter"
      :zoom="7"
      style="width: 100%; height: 400px"
      id="map">
      <GmapMarker
        :key="index"
        v-for="(m, index) in markers"
        :position="m.position"
        @click="center=m.position"
      />
    </GmapMap>
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
    // this.initMap();
    // this.dropPins();
  },

  

  methods: {

    setPlace(place) {
      this.currentPlace = place;
    },

      addMarker() {
      if (this.currentPlace) {
        const marker = {
          lat: this.currentPlace.geometry.location.lat(),
          lng: this.currentPlace.geometry.location.lng(),
        };
        this.markers.push({ position: marker });
        this.places.push(this.currentPlace);
        this.mapCenter = marker;
        this.currentPlace = null;
      }
    },

    // initMap() {
    //   this.map = new window.google.maps.Map(document.getElementById("map"), {
    //     center: this.mapCenter,
    //     zoom: 7,
    //     maxZoom: 20,
    //     minZoom: 6,
    //     zoomControl: true,
    //     mapTypeControl: true,
    //     streetViewControl: true,
    //     fullscreenControl: true,
    //   });

    //   let noPOIStyle = [
    //     {
    //       featureType: "poi",
    //       elementType: "labels",
    //       stylers: [{ visibility: "off" }],
    //     },
    //   ];
    //   this.map.setOptions({ styles: noPOIStyle });
    //   window.google.maps.event.addListener(this.map, "rightclick", (event) => {
    //     this.addPinViaClick(event);
    //   });
  
    // },

    // makeMarkerObj(latLng, name) {
    //   const markerObj = { coord: latLng, name: name };
    //   return markerObj;
    // },

    // addPinViaClick(event) {
    //   let description = window.prompt("Enter a description");
    //   const markerObj = this.makeMarkerObj(event.latLng.toJSON(), description);
    //   this.places.push(markerObj);
    //   this.dropPin(markerObj);
    // },

    // addPinViaInput() {
    //   let latitudeValue = parseFloat(
    //     document.getElementById("latitude-input").value
    //   );
    //   let longitudeValue = parseFloat(
    //     document.getElementById("longitude-input").value
    //   );
    //   const latSelectIndex =
    //     document.getElementById("latitude-direction").selectedIndex;
    //   const lonSelectIndex = document.getElementById(
    //     "longitude-direction"
    //   ).selectedIndex;
    //   const latitudeDirection =
    //     document.getElementById("latitude-direction").options[latSelectIndex]
    //       .text;
    //   const longitudeDirection = document.getElementById("longitude-direction")
    //     .options[lonSelectIndex].text;
    //   const description = document.getElementById("description-input").value;
    //   latitudeValue =
    //     latitudeDirection === "North" ? latitudeValue : -1 * latitudeValue;
    //   longitudeValue =
    //     longitudeDirection === "East" ? longitudeValue : -1 * longitudeValue;
    //   const markerObj = this.makeMarkerObj(
    //     { lat: latitudeValue, lng: longitudeValue },
    //     description
    //   );
    //   this.places.push(markerObj);
    //   this.dropPin(markerObj);
    // },

    // dropPins() {
    //   this.places.forEach((x) => this.dropPin(x));
    // },

    // dropPin(markerObj) {
    //   new window.google.maps.Marker({
    //     position: markerObj.coord,
    //     map: this.map,
    //     label: {
    //       text: markerObj.name,
    //       color: "blue",
    //     },
    //   });
    // },

    geolocate: function () {
      navigator.geolocation.getCurrentPosition((position) => {
        this.mapCenter = {
          lat: position.coords.latitude,
          lng: position.coords.longitude,
        };
      });
    },
  },
};
</script>

<style>
#map-header {
  display: flex;
  grid-template-columns: 1fr 1fr ;
  
}
 
</style>