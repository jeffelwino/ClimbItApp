<template>
  <!-- this is the structure of what a comment will be -->

  <v-card elevation="3">
    <v-card-title
      size="body"
      @click="navigateToProfile(profile.id)"
      class="grey lighten-4 py-2"
    >
      <v-avatar size="24" color="blue" class="mr-3">
        <!-- <v-icon dark> mdi-account-circle </v-icon> -->
        <profile-picture :commentProfile="profile" />
      </v-avatar>
      {{ profile.name }} <v-spacer></v-spacer>
      <caption>
        {{
          comment.postDate
        }}
      </caption></v-card-title
    >
    <v-card-text label="body" outlined>{{ comment.body }}</v-card-text>
  </v-card>
</template>

<script>
import ProfilePicture from "../profile/ProfilePicture.vue";

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
caption {
  font-size: 0.75rem;
}
</style>