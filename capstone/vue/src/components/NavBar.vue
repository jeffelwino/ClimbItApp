<template>
  <v-app-bar app color="blue" dark>
    <v-row class="d-flex align-center">
      <!-- <v-icon large>mdi-spa</v-icon> -->
      <div class="d-flex justify-start">
        <v-img
          src="../assets\climbit-logo-v4.png"
          class="ma-1"
          contain
          height="3rem"
          max-width="2rem"
        ></v-img>
      </div>

      <v-toolbar-title class="
            ma-2
            text-h10
            text-md-h7.5
            
            text-truncate">
        <h1 @click="goToHome">ClimbIt</h1>
      </v-toolbar-title>

      <v-spacer></v-spacer>

      <h4
        class="
            text-h10
            text-md-h9
            text-lg-h8
            text-truncate
        white--text d-flex align-center"
        v-if="$store.state.token === ''"
        @click="goToLogin"
      >
        Log-In/Register
      </h4>

      <!-- pop-out nav menu -->
      <v-menu transition="scroll-y-transition">
        <template v-slot:activator="{ on, attrs }">
          <v-app-bar-nav-icon 
            large
            v-bind="attrs"
            v-on="on"
            v-show="$store.state.token !== ''"
          >
          </v-app-bar-nav-icon>
        </template>
        <v-list color="green">
          <v-list-item exact @click="goToProfile" link>
            <v-list-item-title>View Profile</v-list-item-title>
          </v-list-item>
          <v-divider></v-divider>
          <v-list-item link>
            <v-list-item-title>Lorem Ipsum</v-list-item-title>
          </v-list-item>
          <v-divider></v-divider>

          <v-list-item exact @click="goToLogout" link>
            <v-list-item-title>LogOut</v-list-item-title>
          </v-list-item>
        </v-list>
      </v-menu>
    </v-row>
  </v-app-bar>
</template>

<script>
export default {
  name: "navbar",

  methods: {
    goToProfile() {
      this.$router.push({
        name: "profile",
        params: { id: this.$store.state.user.id },
      });
    },

    goToLogout() {
      this.$router.push({ name: "logout" });
    },
    goToHome() {
      this.$router.push({ name: "home" });
    },
    goToLogin() {
      this.$router.push({ name: "login" });
    },
  },
};
</script>

<style>
</style>