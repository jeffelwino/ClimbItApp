<template>
  
    <v-card class="light-blue">
      <h2>{{ profile.name }}</h2>
      <h3>{{ profile.location }}</h3>
      <p>{{ profile.bio }}</p>
      <v-btn
        v-if="$route.params.id == $store.state.user.id"
        @click="showForm = !showForm"
        >Edit</v-btn
      >

      <v-card v-if="showForm">
        <v-form ref="form">
          <v-text-field
            label="Name"
            v-model="editedProfile.name"
          ></v-text-field>
          <v-text-field
            label="Location"
            v-model="editedProfile.location"
          ></v-text-field>
          <v-text-field label="Bio" v-model="editedProfile.bio"></v-text-field>
          <!-- FOR UPLOADING IMAGES. CURRENTLY FOR SHOW -->
          <v-file-input
            show-size
            disabled
            multiple
            label="Profile Pic"
          ></v-file-input>
          <v-btn @click="updateProfileChanges">Submit</v-btn>
          <v-btn @click="cancelChanges">Cancel</v-btn>
        </v-form>
      </v-card>
    </v-card>
  
</template>

<script>

export default {
  components: {  },
  name: "profile-info",
  data() {
    return {
      showForm: false,
      editedProfile: {},
    };
  },
  computed: {
    profile() {
      return this.$store.state.profiles.find((profile) => {
        return profile.id == this.$route.params.id;
      });
    },
  },
  methods: {
    updateProfileChanges() {
      this.$store.commit("UPDATE_PROFILE", this.editedProfile);
      this.editedProfile = {
        id: this.$route.params.id,
        name: this.profile.name,
        location: this.profile.location,
        bio: this.profile.bio,
        todos: this.profile.todos,
        picture: this.profile.picture,
      };
      this.showForm = false;
    },
    cancelChanges() {
      this.editedProfile = {
        id: this.$route.params.id,
        name: this.profile.name,
        location: this.profile.location,
        bio: this.profile.bio,
        todos: this.profile.todos,
        picture: this.profile.picture,
      };
      this.showForm = false;
    },
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