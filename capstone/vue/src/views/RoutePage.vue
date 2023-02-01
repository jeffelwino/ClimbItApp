<template>
  <div class="route">
    <route-header v-bind:route="route" />
    <!-- image gallery -->
    <route-gallery />
    <route-detail v-bind:route="route" />
    <!-- description -->
    <description></description>

    <!-- <section style="height:10rem; margin-top: 5px; border: 1px solid black"> Recent Ticks</section> -->
    <route-ticks :route="route" />

    <section style="height: 10rem; margin-top: 5px; border: 1px solid black">
      Comments
    </section>
    <!-- Recent Ascents (connected to tickbox)-->
    <!--  Comments -->
  </div>
</template>

<script>
import RouteDetail from "../components/routecomps/RouteDetail.vue";
import RouteHeader from "../components/routecomps/RouteHeader.vue";
import RouteGallery from "../components/images/RouteGallery.vue";
import Description from "../components/Description.vue";
import RouteTicks from "../components/routecomps/RouteTicks.vue";
export default {
  name: "route",
  components: {
    RouteDetail,
    RouteHeader,
    RouteGallery,
    Description,
    RouteTicks,
  },
  data() {
    return {
      route: {
        id: "",
        wall_id: "",
        name: "",
        grade: "",
        height: "",
        style: "",
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