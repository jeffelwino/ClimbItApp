<template>
  <div class="route">
    <div class="stats">
      <h3>Stats:</h3>
      <ul>
        <li>Height: {{ route.height }}</li>
        <li>Style: {{ route.style }}</li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: "route-detail",
  props: ["route"],
  components: {},
  data() {
    return {};
  },
};
</script>

<style>
</style>