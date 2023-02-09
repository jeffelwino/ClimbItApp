<template>
  <v-container class="profile-picture mt-n10">
    <div>
        <v-btn small @click="$router.go(-1)" exact class="back-button mt-n10 justify-start">
            <v-icon small>mdi-arrow-left-circle</v-icon>
            Back
          </v-btn>
      <v-row class="justify-center">
        
        <cld-context v-if="profile.pictureId" cloudName="dacyocfmf" secure="true">
          <!--My publicId is coming back as null -->
          <cld-image
            
            :cloudName="this.$store.state.cloudName"
            :publicId="profile.pictureId" 
            width="300"
          />
        </cld-context>
      </v-row>
    </div>
  </v-container>
</template>

<script>
import profileService from "../../services/ProfileService.js";

export default {
  
  // props: ["profile"],
  data() {
    return {
      profile: {},
      showPicture: false
    };
    // computed: {
    //   profile() {
    //     return this.$store.state.profiles.find((profile) => {
    //       return profile.id == this.$route.params.id;
    //     });
  },
  created() {
    profileService.get(this.$route.params.id).then((response) => {
      if (response.status == 200) {
        console.log(response.data)
        this.profile = response.data;
        
      } else {
        this.$router.push("/notfound");
      }
    });
  },
};
</script>

<style>
.profile-picture img {
  width: 15rem;
  height: 15rem;
  border-radius: 50%;
  border: black solid 2px;
  /* margin-left: 13%; */
}
</style>