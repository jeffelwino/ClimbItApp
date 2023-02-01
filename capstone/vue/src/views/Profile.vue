<template>
  <div class="profile">
    <profile-picture :profile="profile" class="picture" />
    <profile-info :profile="profile" class="info" />
    <profile-ticks :profile="profile" class="ticks" />
  </div>
</template>

<script>
import ProfileInfo from "../components/Profile/ProfileInfo.vue";
import ProfilePicture from "../components/Profile/ProfilePicture.vue";
import ProfileTicks from "../components/Profile/ProfileTicks.vue";
export default {
  components: { ProfilePicture, ProfileInfo, ProfileTicks },
  name: "profile",

  data() {
    return {
      profile: {
        name: "Michael Eden",
        location: "Sunbury, Ohio",
        bio: "My name is Michael and I like to climb rocks",
      },
    };
  },
};
</script>

<style scoped>
.profile {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-areas:
    "picture info"
    "ticks ticks";
}
.picture {
  grid-area: picture;
  margin: 10px;
}
.info {
  grid-area: info;
  margin: 10px;
}
.ticks {
  grid-area: ticks;
  background-color: grey;
  margin: 10px;
}
</style>