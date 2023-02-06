<template>
  <v-container class="profile-picture mt-n10">
    <cld-context cloudName="dacyocfmf" secure="true">
      <cld-image
        :cloudName="profile.picture.cloudName"
        :publicId="profile.picture.publicId"
        width="300"
      />
    </cld-context>
  </v-container>
</template>

<script>
// import Vue from 'vue';
// import Cloudinary from "cloudinary-vue";
// Vue.use(Cloudinary, {
//   configuration: {
//     cloudName: "dacyocfmf",
//     secure: true }
// });

export default {
  props: ["profile"],
  data() {
    return {
      picture: {
        cloudName: this.profile.picture.cloudName,
        publicId: this.profile.picture.publicId
      },
    };
  },
  // computed: {
  //   profile() {
  //     return this.$store.state.profiles.find((profile) => {
  //       return profile.id == this.$route.params.id;
  //     });
  //   },
  // },
  created() {},
};
</script>

<style>
.profile-picture img {
  width: 15rem;
  height: 15rem;
  border-radius: 50%;
  border: black solid 2px;
  margin-left: 13%;  
}
</style>