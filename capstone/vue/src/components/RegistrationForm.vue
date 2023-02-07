<template>

   
<v-card> 
    <v-spacer />

 <v-form class="px-3" v-on:submit.prevent="register">
     <v-card-title class="text-center">
         <h2>Register</h2>
     </v-card-title>
     
      <v-text-field outlined label="Username" v-model="user.username"></v-text-field>

      <v-text-field outlined label="Password" :type="showPassword ? 'text' : 'password'" v-model="user.password"></v-text-field>

      <v-text-field outlined label="Confirm Password" :type="showPassword ? 'text' : 'password'" v-model="user.confirmPassword"></v-text-field>


<v-layout class="mt-5">
    <v-btn>cancel</v-btn>
    <v-spacer></v-spacer>
<v-btn><input type="submit"></v-btn>
</v-layout>

 </v-form>
  </v-card>
 
        
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'registration-form',
  data() {
    return {
        showPassword: false, //hides password when entered
        user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style>

</style>