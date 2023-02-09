<template>
  <div class="tick-display" @click="navigateToPage">
    <v-card overflow-auto class="mb-2 px-2">
      <div>
        <v-layout class="justify-space-around flex-wrap">
          <span class="mt-2 text-subtitle-2 text-sm-h5">
            <span v-if="offProfile">{{ profile.name }}</span>
            {{ tick.date }}
            <span v-if="offRoute">{{ route.name }}</span>
          </span>
          <v-spacer></v-spacer>
          <v-rating
            readonly
            :value="tick.rating"
            class="mr-2 mt-2"
            color="yellow darken-3"
            background-color="grey darken-1"
            empty-icon="$ratingFull"
            dense
            size="0.75rem"
          ></v-rating>
          <v-card-text v-if="showNote">{{ tick.note }}</v-card-text>
        </v-layout>
      </div>
    </v-card>
  </div>
</template>

<script>
import profileService from "../services/ProfileService.js";
import locationService from "../services/LocationService.js";
export default {
  name: "tick-display",
  props: ["tick", "showNote", "offProfile", "offRoute"],
  data() {
    return {
      profile: {},
      route: {},
    };
  },
  methods: {
    navigateToPage() {
      if (this.showNote) {
        this.$router.push({
          name: "route-page",
          params: { id: this.tick.routeId },
        });
      } else {
        this.$router.push({
          name: "profile",
          params: { id: this.tick.profileId },
        });
      }
    },
  },
  created() {
    locationService.getRouteById(this.tick.routeId).then((response) => {
      if (response.status == 200) {
        this.route = response.data;
      }
    });
    profileService.get(this.tick.profileId).then((response) => {
      if (response.status == 200) {
        this.profile = response.data;
      }
    });
  },
};
</script>

<style>
</style>