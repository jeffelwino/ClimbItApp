<template>
  <div>
      
    <state-info />
    <state-map v-bind:state="state"/> 
  </div>
</template>

<script>
import StateInfo from "../components/StateInfo";
import StateMap from '../components/StateMap.vue'
export default {
    name: 'state-detail',
    components: {StateInfo, StateMap},
   
};
    
</script>

<style>

</style>