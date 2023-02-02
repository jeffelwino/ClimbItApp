<template>
  <div class="profile-picture">
    <img src="profile.picture" alt="profile picture" />
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