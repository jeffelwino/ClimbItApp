<template>
  <div class="route">
    <v-container class="route-contents">
      <!-- <v-row> -->
        <route-header v-bind:route="route" />
        <!-- image gallery -->
        <route-gallery />
        <route-detail v-bind:route="route" />
        <!-- description -->
        <div>
          <v-card class="ma-5 pa-2">
            <h4 class="
            text-h6
            text-md-h5
            text-lg-h4
            text-truncate"
            >Description:</h4>

            <p class= 
           "text-h8
            text-md-h5
            text-lg-h4
            text-truncate"
            >{{ route.description }}</p>
          </v-card>
        </div>

        <!-- <section style="height:10rem; margin-top: 5px; border: 1px solid black"> Recent Ticks</section> -->
        <route-ticks :route="route" />

        <section style="height: 10rem; margin-top: 5px; border: 1px solid black">
          Comments
         <route-comment v-bind:route="route"/>  
        </section>
        <!-- Recent Ascents (connected to tickbox)-->
        <!--  Comments -->
      <!-- </v-row> -->
    </v-container>
  </div>
</template>

<script>
import RouteDetail from "../components/routecomps/RouteDetail.vue";
import RouteHeader from "../components/routecomps/RouteHeader.vue";
import RouteGallery from "../components/images/RouteGallery.vue";
// import Description from "../components/Description.vue";
import RouteTicks from "../components/routecomps/RouteTicks.vue";
import RouteComment from "../components/routecomps/RouteComment.vue";

export default {
  name: "route",
  components: {
    RouteDetail,
    RouteHeader,
    RouteGallery,
    // Description,
    RouteTicks,
    RouteComment
  },
  data() {
    return {
      route: {
        id: "",
        wallId: "",
        name: "",
        grade: "",
        height: "",
        style: "",
        description: "",
      },
    };
  },
  methods: {
    loadRoute() {
      this.route = this.$store.state.routes.find((r) => {
        return r.id == this.$route.params.id;
      });
    },
  },
  created() {
    this.loadRoute();
  },
};
</script>

<style>
</style>