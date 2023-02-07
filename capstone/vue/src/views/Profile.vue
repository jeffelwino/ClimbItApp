<template>
  <!-- <div class="profile"> -->
    <v-container>
      <div class="mx-3">
      <v-row class="mt-n15 pb-5 justify-start">
        <v-btn small @click="$router.go(-1)" exact class="back-button">
          <v-icon x-small>mdi-arrow-left-circle</v-icon>
          Back
        </v-btn>
      </v-row>
      </div>
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
export default {
  components: { ProfilePicture, ProfileInfo, ProfileTicks, ProfileTodo },
  name: "profile",
  computed: {
    profile() {
      return this.$store.state.profiles.find((profile) => {
        return profile.id == this.$route.params.id;
      });
    },
  },

  // data() {
  //   return {
  //     profile: {
  //       id: 0,
  //       name: "",
  //       location: "",
  //       bio: "",
  //       todos: [],
  //       picture: "",
  //     },
  //   };
  // },
  // methods: {
  //   loadProfile() {
  //     this.profile = this.$store.state.profiles.find((profile) => {
  //       return profile.id == this.$route.params.id;
  //     });
  //   },
  // },
  // mounted() {
  //   this.loadProfile();
  // },
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