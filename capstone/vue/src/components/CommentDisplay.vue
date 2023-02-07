<template>
  <!-- this is the structure of what a comment will be -->

  <v-card elevation="3">
    <v-card-title
      @click="navigateToProfile(profile.id)"
      class="grey lighten-4 py-2"
    >
      <v-avatar size="36" color="blue" class="mr-3">
        
        <!-- <v-icon dark> mdi-account-circle </v-icon> -->
        <profile-picture :profile="profile"/>
      </v-avatar>
      {{ profile.name }}</v-card-title
    >
    <v-card-text label="body" outlined>{{ comment.body }}</v-card-text>
  </v-card>
  <!-- <v-container class="comment">
            <v-text-field clearable=true outlined label = "Leave a comment here" v-model="body"></v-text-field>
            <v-btn type="submit" @click="submitComment">Submit</v-btn>
        </v-container>
        <v-container class="commentBank">
            <v-textarea outlined label = "List of Comments" v-model="bank"></v-textarea>
        </v-container>  -->
</template>

<script>
import ProfilePicture from "./profile/ProfilePicture.vue";
export default {
  components: { ProfilePicture },
  name: "comment",
  props: ["comment"],
  computed: {
    profile() {
      return this.$store.state.profiles.find((profile) => {
        return profile.id == this.comment.profileId;
      });
    },
  },
  methods: {
    navigateToProfile(id) {
      this.$router.push({ name: "profile", params: { id: id } });
    },
  },
};
</script>

<style>
</style>