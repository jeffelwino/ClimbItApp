<template>
  <!-- this is the structure of what a comment will be -->

  <v-card elevation="3">
    <v-card-title
      @click="navigateToProfile(profile.id)"
      class="grey lighten-4 py-2"
    >
      <v-avatar size="36" color="blue" class="mr-3">
        <!-- <v-icon dark> mdi-account-circle </v-icon> -->
        <profile-picture :profile="profile" />
      </v-avatar>
      {{ profile.name }}</v-card-title
    >
    <v-card-text label="body" outlined>{{ comment.body }}</v-card-text>
  </v-card>
</template>

<script>
import ProfilePicture from "../profile/ProfilePicture.vue";
// import commentService from "../../services/CommentService.js";
import profileService from "../../services/ProfileService.js";
export default {
  components: { ProfilePicture },
  name: "comment",
  data() {
    return {
      profile: {},
    };
  },

  props: ["comment"],
  // computed: {
  //   // profile() {
  //   //   return this.$store.state.profiles.find((profile) => {
  //   //     return profile.id == this.comment.profileId;
  //   //   });
  //   // },
  // },
  methods: {
    navigateToProfile(id) {
      this.$router.push({ name: "profile", params: { id: id } });
    },
  },
  created() {
    profileService.get(this.comment.profileId).then((response) => {
      if (response.status == 200) {
        this.profile = response.data;
      }
    });
  },
};
</script>

<style>
</style>