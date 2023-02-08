<template>
  <!-- <div class="profile"> -->
  <v-container>
    <profile-picture :profile="profile" class="picture" />
    <profile-info :profile="profile" class="info" />
    <profile-ticks :profile="profile" class="ticks" />
    <profile-todo :profile="profile" class="todo" />
  </v-container>
  <!-- </div> -->
</template>

<script>
import ProfileInfo from "../components/profile/ProfileInfo.vue";
import ProfilePicture from "../components/profile/ProfilePicture.vue";
import ProfileTicks from "../components/profile/ProfileTicks.vue";
import ProfileTodo from "../components/profile/ProfileTodo.vue";
import profileService from "../services/ProfileService.js";

export default {
  components: { ProfilePicture, ProfileInfo, ProfileTicks, ProfileTodo },
  name: "profile",
  data() {
    return {
      profile: {},
    };
  },
  created() {
    profileService
      .get(this.$route.params.id)
      .then((response) => {
        if (response.status == 200) {
          this.profile = response.data;
        }
      })
      .catch((error) => {
        console.log(error);
        if (error.response.status == 404) {
          this.$router.push({ name: "NotFound" });
        }
      });
  },
};
</script>

<style scoped>
.profile {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-areas:
    "picture info"
    "ticks ticks"
    "todo todo";
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
}
.todo {
  grid-area: todo;
}
</style>