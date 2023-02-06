<template>
    <div>
      <!-- <submit-photo/> -->
      <cloudinary/>
    </div>
</template>

<script>
import Cloudinary from '../components/imageComps/Cloudinary.vue'
// import SubmitPhoto from '../components/SubmitPhoto.vue'


export default {
  components: { Cloudinary },
  data() {
      return{
        route: { id: 1, wallId: 1, name: 'Slappy McCracken', grade: '5.10b', height: '30ft', style: 'sport', description: 'The oldest climbing route in Ohio. Very busy during the weekend.' },
        crag:  { id: 1, areaId: 1, name: 'Mad River Gorge', description: 'The finest climbing Ohio has to offer', latitude: 39.912833, longitude: -83.860439 },
      }
  }  
}
</script>

<style>

</style>