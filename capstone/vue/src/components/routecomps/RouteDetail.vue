<template>
  <v-container width="110%">
    <v-card class="my-auto justify-center">
      <v-card-title> <h3>Stats:</h3> </v-card-title>
      <v-divider></v-divider>
      <v-card-text class="justify-center">
        <v-layout>
          <v-row>
            <h1 class="text-h6 text-md-h5 text-lg-h4 text-truncate">
              <v-list>
                <v-list-item>Height: {{ route.height }}</v-list-item>
                <v-list-item>Style: {{ route.style }}</v-list-item>
                <v-list-item>
                  Rating:
                  <v-rating
                    v-if="averageRating"
                    readonly
                    dense
                    v-model="averageRating"
                    color="yellow darken-3"
                    background-color="grey darken-1"
                    empty-icon="$ratingFull"
                    hover
                    size="20"
                  >
                  </v-rating>
                  <caption>
                    ({{
                      ticks.length
                    }}
                    reviews)
                  </caption>
                </v-list-item>
                <v-list-item>Protection: {{ route.protection }} </v-list-item>
              </v-list>
              <!-- <v-spacer></v-spacer> -->
              <v-list> </v-list>
            </h1>
          </v-row>
          <!-- </v-col> -->
        </v-layout>
      </v-card-text>
    </v-card>
  </v-container>
</template>

<script>
import tickService from "../../services/TickService.js";
export default {
  name: "route-detail",
  props: ["route"],
  data() {
    return {
      ticks: [],
    };
  },

  computed: {
    averageRating() {
      let sum = this.ticks.reduce((currentSum, tick) => {
        return currentSum + tick.rating;
      }, 0);
      return (sum / this.ticks.length).toFixed(2);
    },
  },
  created() {
    tickService.listByRoute(this.$route.params.id).then((response) => {
      if (response.status == 200) {
        this.ticks = response.data;
      }
    });
  },
};
</script>

<style>
</style>