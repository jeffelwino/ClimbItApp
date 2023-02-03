<template>
  <div class="info">
    <h2>{{ profile.name }}</h2>
    <h3>{{ profile.location }}</h3>
    <p>{{ profile.bio }}</p>
    <v-btn @click="showForm = !showForm">Edit</v-btn>

<<<<<<< HEAD
    <v-card v-if="showForm === true">
      <v-form ref="form">
        <v-text-field label="profile.name" v-model="editedProfile.name"></v-text-field>
        <v-text-field label="location" v-model="editedProfile.location"></v-text-field>
        <v-text-field label="bio" v-model="editedProfile.bio"></v-text-field>
=======
    <v-card v-if="showForm">
      <v-form ref="form">
        <v-text-field label="Name" v-model="editedProfile.name"></v-text-field>
        <v-text-field
          label="Location"
          v-model="editedProfile.location"
        ></v-text-field>
        <v-text-field label="Bio" v-model="editedProfile.bio"></v-text-field>
>>>>>>> main
        <v-btn @click="updateProfileChanges">Submit</v-btn>
        <v-btn @click="reset">Cancel</v-btn>
      </v-form>
    </v-card>
  </div>
</template>

<script>
export default {
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
        id: this.profile.id,
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
        id: this.profile.id,
        name: this.profile.name,
        location: this.profile.location,
        bio: this.profile.bio,
        todos: this.profile.todos,
        picture: this.profile.picture,
      };
      this.showForm = false;
    },
  },
<<<<<<< HEAD
  reset () {
        this.$refs.form.reset()
      },
  // cancelChanges(){
  //   this.showForm = false;
  //   console.log(this.profile)
  //    this.editedProfile =  {
  //        name: '',
  //        location: '',
  //        bio: ''
  //      };
  // }
=======
  created() {
    this.editedProfile = {
      id: this.profile.id,
      name: this.profile.name,
      location: this.profile.location,
      bio: this.profile.bio,
      todos: this.profile.todos,
      picture: this.profile.picture,
    };
>>>>>>> main
  },
};
</script>

<style scoped>
.info {
  text-align: center;
}
</style>