<template>
  <div class="info">
    <h2>{{ profile.name }}</h2>
    <h3>{{ profile.location }}</h3>
    <p>{{ profile.bio }}</p>
    <v-btn @click="showForm = !showForm">Edit</v-btn>

    <v-card v-if="showForm">
      <v-form>
        <v-text-field label="Name" v-model="editedProfile.name"></v-text-field>
        <v-text-field
          label="Location"
          v-model="editedProfile.location"
        ></v-text-field>
        <v-text-field label="Bio" v-model="editedProfile.bio"></v-text-field>
        <v-btn @click="updateProfileChanges">Submit</v-btn>
        <v-btn @click="cancelChanges">Cancel</v-btn>
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
      //  originalProfile: this.profile,
      editedProfile: {
        id: this.$store.state.user.id,
        name: "",
        location: "",
        bio: "",
      },
    };
  },
  computed: {
    profile() {
      return this.$store.state.profiles.find((profile) => {
        return profile.id == this.$route.params.id;
      });
    },
  },
  // props: ["profile"],
  methods: {
    updateProfileChanges() {
      console.log("update, profile, edited profile: ");
      console.log(this.profile);
      console.log(this.editedProfile);
      this.$store.commit("UPDATE_PROFILE", this.editedProfile);
      this.editedProfile = {
        id: this.$store.state.user.id,
        name: "",
        location: "",
        bio: "",
      };
      this.showForm = false;
    },
    cancelChanges() {
      console.log("Cancel change, profile, edited profile:");
      console.log(this.profile);
      console.log(this.editedProfile);
      this.editedProfile = {
        id: this.$store.state.user.id,
        name: "",
        location: "",
        bio: "",
      };
      this.showForm = false;
    },
  },
  created() {
    //  this.editedProfile = this.profile;
  },
};
</script>

<style scoped>
.info {
  text-align: center;
}
</style>