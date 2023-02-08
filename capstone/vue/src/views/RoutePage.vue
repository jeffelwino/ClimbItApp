<template>
  <div class="route">
    <v-container class="route-contents" justify:center>
      <div class="mx-3">
        <v-row class="mt-n15 pb-15 mR-5 justify-start">
          <v-btn x-small @click="navigateUp" exact class="back-button">
            <v-icon x-small>mdi-arrow-left-circle</v-icon>
            To Wall
          </v-btn>
        </v-row>
      </div>
      <!-- header -->
      <route-header v-bind:route="route" />
      <route-tools
        v-if="this.$store.state.user.authorities[0].name == 'ROLE_ADMIN'"
      />
      <!-- image gallery -->
      <route-gallery />
      <v-card class="ma-5 pa-2">
        <h4 class="text-h6 text-md-h5 text-lg-h4 text-truncate">
          Description:
        </h4>
        <p
          class="
            text--secondary
            text-caption
            text-sm-body-2
            text-md-body-1
            text-lg-body-1
            text-xl-body-1
            text-justify
          "
        >
          {{ route.description }}
        </p>
      </v-card>
      <route-detail v-bind:route="route" />
      <!-- description -->
      <div></div>

      <!-- Recent Ascents (connected to tickbox)-->
      <v-container>
        <route-ticks :route="route" />
      </v-container>

      <!-- Comments Section -->
      <v-container>
        <route-comment v-bind:route="route" />
      </v-container>
    </v-container>
  </div>
</template>

<script>
import RouteDetail from "../components/routecomps/RouteDetail.vue";
import RouteHeader from "../components/routecomps/RouteHeader.vue";
import RouteGallery from "../components/imageComps/RouteGallery.vue";
// import Description from "../components/Description.vue";
import RouteTicks from "../components/routecomps/RouteTicks.vue";
import RouteComment from "../components/routecomps/RouteComment.vue";
import RouteTools from "../components/adminTools/RouteTools.vue";
import locationService from "../services/LocationService";

export default {
  name: "route",
  components: {
    RouteDetail,
    RouteHeader,
    RouteGallery,
    RouteTicks,
    RouteComment,
    RouteTools,
  },
  data() {
    return {
      route: {},
    };
  },
  methods: {
    navigateUp() {
      this.$router.push({ name: "wall", params: { id: this.route.wallId } });
    },
  },
  created() {
    locationService.getRouteById(this.$route.params.id).then((response) => {
      if (response.status == 200) {
        this.route = response.data;
      }
    });
  },
};
</script>

<style>
</style>