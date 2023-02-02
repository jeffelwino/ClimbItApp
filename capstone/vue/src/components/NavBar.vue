<template>
  <v-app-bar app color="blue" dark>
    <v-row align="end">
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

      <v-toolbar-title class="ml-5" @click="goToHome">
        <h1>ClimbIt</h1>
      </v-toolbar-title>

      <v-spacer></v-spacer>

      <h4
        class="white--text d-flex align-center"
        v-show="$store.state.token === ''"
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
          <v-list-item exact @click="goToProfile">
            <v-list-item-title>View Profile</v-list-item-title>
          </v-list-item>
          <v-divider></v-divider>
          <v-list-item>
            <v-list-item-title>Lorem Ipsum</v-list-item-title>
          </v-list-item>
          <v-divider></v-divider>

          <v-list-item exact @click="goToLogout">
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
      this.$router.push({ name: "profile" });
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