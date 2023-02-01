<template>
  
    <v-container>
      <v-card class="ma-5 justify-center" border="2px solid black" width="90%">
      <v-card-title> <h3>Stats:</h3>  </v-card-title>
      <v-card-text>
      <v-layout>
        <!-- <v-col
          cols="12"
          sm="6"
          md="3"> -->
        <ul>
        <li>Height: {{ route.height }}</li>
        <li>Style: {{ route.style }}</li>
        </ul>
      
          <!-- </v-col>
          <v-col -->
          <!-- cols="12"
          sm="6"
          md="3"> -->
          <ul  class="ml-10">
        <li>Rating: 
          
           <v-rating
             readonly
            v-model="averageRating"
            color="yellow darken-3"
            background-color="grey darken-1"
            empty-icon="$ratingFull"
            hover
            x-small>
        </v-rating>
        </li>
        <li>Protection</li>
      </ul>
          <!-- </v-col> -->
      </v-layout>
      </v-card-text>
      </v-card>
    </v-container>
 
</template>

<script>

export default {
  name: "route-detail",
  props: ["route"],

  computed: {
        averageRating() {
            const ticks = this.$store.state.ticks.filter((t) => {
            return t.route_id == this.route.id;});
            let sum = ticks.reduce((currentSum, tick) => {
            return currentSum + tick.rating;
            }, 0);
            return(sum / ticks.length).toFixed(2);
        }
        },
  data() {
    return {};
  },
};
</script>

<style>
</style>