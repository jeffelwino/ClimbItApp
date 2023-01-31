<template>
<v-container>
  <div class="home">
    <h1>Home</h1>
  
    <display-map/>

    <v-sheet class="mt-5">
      <state-list></state-list>
    </v-sheet>
  </div>
  </v-container>
</template>

<script>
import DisplayMap from '../components/DisplayMap.vue';
import StateList from '../components/StateList.vue';

export default {
  components: { DisplayMap, StateList },
  name: "home"
};
</script>
