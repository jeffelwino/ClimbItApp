<template>
    <div>
        <crag-comment v-bind:crag="crag"/>
        <!-- <display-comment></display-comment>
        <wall-card></wall-card> -->
    </div>
</template>

<script>
import CragComment from "../components/CragComment.vue"
// import DisplayComment from '../components/DisplayComment.vue'
// import WallCard from '../components/WallCard.vue'

export default {
  components: { CragComment },
  data() {
      return{
        route: { id: 1, wallId: 1, name: 'Slappy McCracken', grade: '5.10b', height: '30ft', style: 'sport', description: 'The oldest climbing route in Ohio. Very busy during the weekend.' },
        crag:  { id: 1, areaId: 1, name: 'Mad River Gorge', description: 'The finest climbing Ohio has to offer', latitude: 39.912833, longitude: -83.860439 }

      }
  }  
}
</script>

<style>

</style>