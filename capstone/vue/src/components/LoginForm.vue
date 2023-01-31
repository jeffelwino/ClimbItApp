<template>
    <div id="login" class="text-center">
    <v-form class="form-signin px-5" @submit.prevent="login">
      <h1 class="h3 mb-3 font-weight-normal">Please Sign In</h1>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      > <v-alert transition="scale-transition"> Invalid username and password! </v-alert></div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      > <v-alert transition="scale-transition"> Thank you for registering, please sign in.</v-alert></div>

      <v-sheet>
          <v-row justify="space-around">
               <!-- <label for="username" class="sr-only">Username</label> -->
      <v-text-field
        outlined
        label="username"
        class="form-control"
        v-model="user.username"
        required
        autofocus
      > </v-text-field>
      
      <!-- <label for="password" class="sr-only">Password</label> -->
      <v-text-field
       outlined
        type="password"
        label="password"
        class="form-control"
        v-model="user.password"
        required
      ></v-text-field>

          </v-row>
          </v-sheet>
        
        
      <router-link :to="{ name: 'register' }">Need an account?</router-link>
      <v-btn class="ml-5" type="submit">Sign in</v-btn>
    </v-form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login-form",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};


</script>

<style>

</style>