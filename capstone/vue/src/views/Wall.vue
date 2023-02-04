<template>
  <div class="wall">
    <wall-tools v-if="this.$store.state.user.authorities[0].name =='ROLE_ADMIN'" />

    <!-- return to crag page button -->
      <div class="mx-5">
      <v-row class="mt-n10 pb-5 justify-start">
        <v-btn x-small v-bind:to="{name: 'crag', params: '{id: wall.cragId}'}">
          <v-icon x-small >mdi-arrow-left-circle</v-icon>   
            to crag 
            </v-btn>
            </v-row>
            </div>
    
       
      <div class="card mx-3"> 
     
    <wall-detail v-bind:wall="wall" />
    </div> 
    
         

  </div>
</template>

<script>
import WallDetail from "../components/wall/WallDetail.vue";
import WallTools from '../components/adminTools/WallTools.vue';
export default {
  name: "wall",
  components: { WallDetail, WallTools },
  computed: {
    wall(){
      return this.$store.state.walls.find(w => {
        return w.id == this.$route.params.id;
      });
    }
  }
};
</script>

<style scoped>

</style>