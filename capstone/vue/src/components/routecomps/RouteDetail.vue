<template>
  
    <v-container>
      <v-card class="ma-4 justify-center" width="90%">
      <v-card-title> <h3>Stats:</h3>  </v-card-title>
      <v-divider></v-divider>
      <v-card-text class="justify center">
      <v-layout>

        <v-list>
        <v-list-item>Height: {{ route.height }}</v-list-item>
        <v-list-item>Style: {{ route.style }}</v-list-item>
        </v-list>
        <!-- <v-spacer></v-spacer> -->
          <v-list  class="ml-10">
        <v-list-item> Rating:  
          <v-rating
             readonly
             dense
            v-model="averageRating"
          
            color="yellow darken-3"
            background-color="grey darken-1"
            empty-icon="$ratingFull"
            hover
            size="12">
        </v-rating>
          
           
        </v-list-item>
        <v-list-item>Protection: </v-list-item>
      </v-list>
          <!-- </v-col> -->
      </v-layout>g
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
            return t.routeId == this.route.id;});
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