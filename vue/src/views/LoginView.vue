<template>
  <div id="login">
    <form v-on:submit.prevent="login">
      <h1>Please Sign In</h1>
      <!-- Show error message if invalid credentials -->
      <div role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <!-- Show registration success message -->
      <div role="alert" v-if="$route.query.registration">
        Thank you for registering, please sign in.
      </div>
      <div class="form-input-group">
        <label for="username">Username</label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-group">
        <label for="password">Password</label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
      <button type="submit">Sign in</button>
      <p>
        <router-link v-bind:to="{ name: 'register' }">Need an account? Sign up.</router-link>
      </p>
    </form>
  </div>
</template>
<script>

import authService from "../services/AuthService";
export default {
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
          // Set invalidCredentials to true if authentication fails
          if (response && response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>
<style scoped>
 
body {
 
  display: center;
  justify-content: center;
  align-items: center;
  height: 100vh;
  margin: 0;
}
/* Main container styling */
#login {
  
  padding: 30px;
  border-radius: 20px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  max-width: 400px; 
  width: 100%;
}
/* Form input group styling */
.form-input-group {
  margin-bottom: 2.5rem; 
}

/* Label styling */
label {
  margin-right: 2rem; 
  color: #4e4c4c; 
}

/* Input field styling */
input[type="text"],
input[type="password"] {
  width: 85%; 
  padding: .5rem; 
  border: 2px solid #b8b0b0; 
  border-radius: 10px; 
}

/* Submit button styling */
button[type="submit"] {
  background-color: #844cc5; 
  color: #111111; 
  padding: 0.5rem 1rem; 
  border: none; 
  border-radius: 5px; 
  cursor: pointer; 
  transition: background-color 0.3s ease; 
}
/* Hover effect for submit button */
button[type="submit"]:hover {
  background-color: #3527b1; 
}

/* Scoped styles for the component */
/* Add any additional scoped styles here if needed */

.form-input-group {
    margin-bottom: 1rem;
  }
  label {
    margin-right: 0.5rem;
  }
</style>