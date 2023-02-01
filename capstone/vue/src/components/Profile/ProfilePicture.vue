<template>
  <div class="profile-picture">
    <img src="../../assets/profile-picture.jpg" alt="profile picture" />
  </div>
</template>

<script>
export default {
  props: ["profile"],
};
</script>

<style>
.profile-picture img {
  width: 100%;
  border-radius: 50%;
  border: black solid 5px;
}
</style>