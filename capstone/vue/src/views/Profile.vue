<template>
  <div class="profile">
    <profile-picture :profile="profile" class="picture" />
    <profile-info :profile="profile" class="info" />
    <profile-ticks :profile="profile" class="ticks" />
    <profile-todo :profile="profile" class="todo" />
  </div>
</template>

<script>
import ProfileInfo from "../components/profile/ProfileInfo.vue";
import ProfilePicture from "../components/profile/ProfilePicture.vue";
import ProfileTicks from "../components/profile/ProfileTicks.vue";
import ProfileTodo from "../components/profile/ProfileTodo.vue";
export default {
  components: { ProfilePicture, ProfileInfo, ProfileTicks, ProfileTodo },
  name: "profile",

  data() {
    return {};
  },
  computed: {
    profile() {
      return this.$store.state.profiles.find((p) => {
        return (p.id = this.$route.params.id);
      });
    },
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
  background-color: grey;
  margin: 10px;
}
.todo {
  grid-area: todo;
  background-color: grey;
  margin: 10px;
}
</style>