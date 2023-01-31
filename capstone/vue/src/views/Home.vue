<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <display-map/>

    <div>
      <StateList></StateList>

    </div>
  </div>
</template>

<script>
import DisplayMap from '../components/DisplayMap.vue';
import StateList from '../components/StateList.vue';

export default {
  components: { DisplayMap, StateList },
  name: "home"
};
</script>
