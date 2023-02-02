<template>
  <div class="wall">
    <div class="description">
      <h3>Description:</h3>
      <p>{{ wall.description }}</p>
    </div>
    <div class="routes">
      <route-card v-for="route in routes" :key="route.id" :route="route"/>
    </div>
  </div>
</template>

<script>
import RouteCard from "./RouteCard.vue"

export default {
  name: "wall-detail",
  props: ["wall"],
  components: { RouteCard },
  data() {
    return {
      routes: [],
      ticks: []
    };
  },
  methods: {
    loadRoutes() {
      this.$store.state.routes.forEach((route) => {
        if (route.wallId == this.wall.id) {
          this.routes.push(route);
        }
      });  
    },
    loadTicks(){
      this.$store.state.ticks.forEach((tick) => {
        this.routes.forEach(route => {
          if(tick.routeId == route.id){
            this.ticks.push(tick);
          }
        });
      })
    }
  },
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
  created() {
    this.loadRoutes();
    this.loadTicks();
  },
};
</script>

<style>
</style>