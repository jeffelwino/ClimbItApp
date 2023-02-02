<template>
  <v-card>{{route.name}} ({{route.grade}})           
      <v-rating
           readonly
           v-model="averageRating"
           half-increments
           color="yellow darken-3"
           background-color="grey darken-1"
           empty-icon="$ratingFull"
           ></v-rating>
    </v-card>
</template>

<script>

export default {
    name: "route-card",
    props: ["route"], 
    computed: {
        ticks(){
            return this.$store.state.ticks.filter(tick => {
                return tick.routeId == this.route.id;
            }
        )},
        averageRating(){
            let sum = 0
            this.ticks.forEach(tick => {
                sum += tick.rating
            })
            return sum /= this.ticks.length
        }
    }
}
</script>

<style>

</style>