<template>
  <v-card class="light-blue white--text">
    <h2 class="secondary">{{ profile.name }}</h2>
    <h3>{{ profile.location }}</h3>
    <p>{{ profile.bio }}</p>
    <v-btn
      class="mb-2"
      outlined
      v-if="$route.params.id == $store.state.user.id"
      @click="snapShot"
    >
      <v-icon>mdi-pencil</v-icon>
    </v-btn>

    <v-card v-if="showForm">
      <v-form ref="form">
        <v-text-field
          label="Name"
          clearable
          v-model="editedProfile.name"
        ></v-text-field>
        <v-text-field
          label="Location"
          clearable
          v-model="editedProfile.location"
        ></v-text-field>
        <v-text-field
          label="Bio"
          clearable
          v-model="editedProfile.bio"
        ></v-text-field>
        <!-- FOR UPLOADING IMAGES. CURRENTLY FOR SHOW -->
        <!-- <v-file-input
            show-size
            disabled
            multiple
            label="Profile Pic"
          ></v-file-input> -->

        <v-btn @click="updateProfileChanges">Submit</v-btn>
        <v-btn @click="cancelChanges">Cancel</v-btn>
        <cloudinary />
      </v-form>
    </v-card>
  </v-card>
</template>

<script>
import profileService from "../../services/ProfileService.js";
import Cloudinary from "../imageComps/Cloudinary.vue";
export default {
  components: { Cloudinary },
  name: "profile-info",
  data() {
    return {
      profile: {},
      showForm: false,
      editedProfile: {},
      currentPicture: "",
    };
  },

  methods: {
    snapShot() {
      this.currentPicture = this.profile.pictureId;
      this.showForm = !this.showForm;
    },
    updateProfileChanges() {
      profileService
        .put(this.editedProfile)
        .then((response) => {
          if (response.status == 200) this.$router.go(0);
        })
        .catch((error) => {
          if (error.response) {
            window.alert("There was an error updating your profile");
          }
        });
      this.showForm = false;
    },
    cancelChanges() {
      this.editedProfile = {};
      this.showForm = false;
    },
    refreshEditedProfile() {
      this.editedProfile = {
        id: this.$route.params.id,
        name: this.profile.name,
        location: this.profile.location,
        bio: this.profile.bio,
        todos: this.profile.todos,
        picture: this.profile.picture,
      };
    },
  },
  created() {
    profileService.get(this.$route.params.id).then((response) => {
      if (response.status == 200) {
        this.profile = response.data;
        this.refreshEditedProfile();
        // this.snapShot();
      }
    });
  },
};
</script>

<style scoped>
.info {
  text-align: center;
}
</style>