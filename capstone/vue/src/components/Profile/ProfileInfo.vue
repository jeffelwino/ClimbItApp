<template>
  <div class="info">
    <h2>{{ profile.name }}</h2>
    <h3>{{ profile.location }}</h3>
    <p>{{ profile.bio }}</p>
  </div>
</template>

<script>
export default {
  name: "profile-info",
  props: ["profile"],
};
</script>

<style scoped>
.info {
  text-align: center;
}
</style>