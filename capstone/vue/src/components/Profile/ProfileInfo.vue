<template>
  <div class="info">
    <h2>{{ profile.name }}</h2>
    <h3>{{ profile.location }}</h3>
    <p>{{ profile.bio }}</p>
    <v-btn @click="showForm = !showForm">Edit</v-btn>

    <v-card v-if="showForm === true">
      <v-form ref="form">
        <v-text-field label="profile.name" v-model="editedProfile.name"></v-text-field>
        <v-text-field label="location" v-model="editedProfile.location"></v-text-field>
        <v-text-field label="bio" v-model="editedProfile.bio"></v-text-field>
        <v-btn @click="updateProfileChanges">Submit</v-btn>
        <v-btn @click="reset">Cancel</v-btn>
      </v-form>


    </v-card>
  </div>
  
</template>

<script>
export default {
  name: "profile-info",
  data(){
    return{
      showForm: false,
      //  originalProfile: this.profile,
       editedProfile: {
         name: '',
         location: '',
         bio: ''
       }
    }
  },
  computed:{
    profile(){
    return this.$store.state.profiles.find(profile => {
      console.log(profile);
      return profile.id == this.$route.params.id;
    });
    }
  },
  // props: ["profile"],
  methods: {
      updateProfileChanges() {
      this.$store.commit("UPDATE_PROFILE", this.editedProfile);
      console.log(this.profile);
      this.showForm = false;
      this.editedProfile =  {
         name: '',
         location: '',
         bio: ''
       };
  },
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
  },
  created(){
  //  this.editedProfile = this.profile;

  }

};
</script>

<style scoped>
.info {
  text-align: center;
}
</style>