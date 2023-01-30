<template>

<v-container
> 
 <form v-on:submit.prevent="register">
    

    <h2>Registration Form</h2> 
    <label for="email">Email</label>
     <input type="email" name="email" v-model="user.email"><br>

<label for="username">Username</label>
<input type="text" name="username" v-model="user.username"><br>

<label for="password">Password</label>
<input type="text" name="password" v-model="user.password"><br>

<label for="confirm-password">Confirm Password</label>
<input type="text" name="confirm-password" v-model="user.confirmPassword"><br>

<label for="location">Location</label>
<input type="text" name="location" v-model="user.location"><br>

<label for="bio">About Me</label>
<textarea id="bio" name="bio" rows="8" cols="30" v-model="user.bio" ></textarea><br>

<button><input type="submit"> </button>
 </form>
  </v-container>
        
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'registration-form',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        email: '',
        location: '',
        bio: '',
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

<style scoped>

form{ 
    
    max-width: 50vh;
    border: 2px solid black;
    text-align: right;
    padding-right: 2rem;
}

h2{
    text-align: center;
}

input{
    margin: 20px;
    border: 1mm solid black;

}

textarea{
    border: 1mm solid black;
margin-right: 1.5rem;
}


</style>