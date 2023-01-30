<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <display-map/>
  </div>
</template>

<script>
import DisplayMap from '../components/DisplayMap.vue';
export default {
  components: { DisplayMap },
  name: "home"
};
</script>
