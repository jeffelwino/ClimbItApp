<template>
    <v-container>
        <wall-card v-for="wall in walls" :key="wall.id" v-bind:wall="wall"></wall-card>
    </v-container>
</template>

<script>
import WallCard from './WallCard.vue'
export default {
  components: { WallCard },
  props: ["crag"],
  data(){
      return {
          walls: []
      }
  },
  methods: {
        loadWalls() {
            this.$store.state.walls.forEach((wall) => {
                if(wall.cragId == this.crag.id) {
                    this.walls.push(wall);
                }
            });
        }
  },
    created(){
        this.loadWalls();
    }

}
</script>

<style>

</style>