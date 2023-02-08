<template>
  <v-card class="light-blue">
    <h2>{{ profile.name }}</h2>
    <h3>{{ profile.location }}</h3>
    <p>{{ profile.bio }}</p>
    <v-btn v-if="$route.params.id == $store.state.user.id" @click="snapShot">
      Edit</v-btn
    >

    <v-card v-if="showForm">
      <v-form ref="form">
        <v-text-field label="Name" v-model="editedProfile.name"></v-text-field>
        <v-text-field label="Location" v-model="editedProfile.location"></v-text-field>
        <v-text-field label="Bio" v-model="editedProfile.bio"></v-text-field>
        <!-- FOR UPLOADING IMAGES. CURRENTLY FOR SHOW -->
        <!-- <v-file-input
            show-size
            disabled
            multiple
            label="Profile Pic"
          ></v-file-input> -->
        <cloudinary />
        <v-btn @click="updateProfileChanges">Submit</v-btn>
        <v-btn @click="cancelChanges">Cancel</v-btn>
      </v-form>
    </v-card>
  </v-card>
</template>

<script>
import Cloudinary from "../imageComps/Cloudinary.vue";
import profileService from "../../services/ProfileService.js";
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
      this.currentPicture = this.editedProfile.pictureId;
      this.showForm = !this.showForm;
    },
    updateProfileChanges() {
      profileService.put(this.editedProfile).then(
        () => {
          window.alert("Profile Recently updated")
        }
      ).catch(
        (error) => {
          if(error.response) {
            window.alert("There was an error updating your profile");
          }
        }
      )
      this.showForm = false;
    },
    cancelChanges() {
      this.editedProfile = {};
      this.showForm = false;
    },
  },
  created() {
    profileService.get(this.$route.params.id).then((response) => {
      if (response.status == 200) {
        this.profile = response.data;
      }
    });
  },
  mounted() {
    this.editedProfile = {
      id: this.$route.params.id,
      name: this.profile.name,
      location: this.profile.location,
      bio: this.profile.bio,
      todos: this.profile.todos,
      picture: this.profile.picture,
    };
  },
};
</script>

<style scoped>
.info {
  text-align: center;
}
</style>