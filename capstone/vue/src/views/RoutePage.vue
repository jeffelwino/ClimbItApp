<template>
  <div class="d-flex block">
    <v-container class="route-contents" justify:center>
      <!-- header -->
      <route-header v-bind:route="route"> </route-header>
      <route-tools
        v-if="this.$store.state.user.authorities[0].name == 'ROLE_ADMIN'"
      />
      <!-- image gallery -->
      <route-gallery />

      <!-- description -->
      <v-card id="description" class="my-5 pa-2">
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

      <!-- Recent Ascents (connected to tickbox)-->

      <route-ticks :route="route" />

      <!-- Comments Section -->
      <div class="comments">
        <route-comment v-bind:route="route" />
      </div>
    </v-container>
  </div>
</template>

<script>
import RouteDetail from "../components/routecomps/RouteDetail.vue";
import RouteHeader from "../components/routecomps/RouteHeader.vue";
import RouteGallery from "../components/imageComps/RouteGallery.vue";
import RouteTicks from "../components/routecomps/RouteTicks.vue";
import RouteComment from "../components/commentComps/RouteComment.vue";
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

<style scoped>
#description {
  width: 93%;
  margin-left: 4%;
}
</style>