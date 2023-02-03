<template>
  <div class="wall">
    <wall-tools v-if="this.$store.state.user.authorities[0].name =='ROLE_ADMIN'" />
    <h2>{{ wall.name }}</h2>
    <wall-detail v-bind:wall="wall" />
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

<style>
</style>