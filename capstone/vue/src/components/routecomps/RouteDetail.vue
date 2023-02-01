<template>
  
    <div class="stats ma-5" style="width: 90%">
      <v-card class="grey justify-center">
      <h3>Stats:</h3> 
      <v-row>
        <v-col
          cols="12"
          sm="6"
          md="3">
          <ul>
        <li>Height: {{ route.height }}</li>
        <li>Style: {{ route.style }}</li>
      </ul>
          </v-col>
          <v-col
          cols="12"
          sm="6"
          md="3">
          <ul>
        <li>Rating (stars)</li>
        <li>Protection</li>
      </ul>
          </v-col>
      </v-row>
      </v-card>
    </div>
 
</template>

<script>
export default {
  name: "route-detail",
  props: ["route"],
  components: {},
  data() {
    return {};
  },
};
</script>

<style>
</style>