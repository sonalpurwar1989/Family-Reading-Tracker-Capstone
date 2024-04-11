<template>
  <div id="capstone-app">
    <!-- Hamburger menu -->
    <div id="menu" @click="toggleMenu">
      <div class="bar"></div>
      <div class="bar"></div>
      <div class="bar"></div>
    </div>
    
    <!-- Registration form -->
    <div class="registration-form" v-if="!$store.state.token">
      <h2>Register</h2>
      <form @submit.prevent="register">
        <label for="username">Username:</label>
        <input type="text" id="username" v-model="username" placeholder="Enter your username" required>
        <label for="email">Email:</label>
        <input type="email" id="email" v-model="email" placeholder="Enter your email" required>
        <label for="password">Password:</label>
        <input type="password" id="password" v-model="password" placeholder="Enter your password" required>
        <label for="confirm-password">Confirm Password:</label>
        <input type="password" id="confirm-password" v-model="confirmPassword" placeholder="Confirm your password" required>
        <button type="submit">Register</button>
      </form>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      username: '',
      email: '',
      password: '',
      confirmPassword: '',
      showMenu: false // Initially hide the menu
    };
  },
  methods: {
    register() {
      // Implement your registration logic here
      // You can access username, email, password, and confirmPassword using this.username, this.email, this.password, and this.confirmPassword
    },
    toggleMenu() {
      this.showMenu = !this.showMenu; // Toggle the menu visibility
    }
  }
};
</script>
<style scoped>
#capstone-app {
  font-family: Arial, sans-serif;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100vh;
  position: relative;
}
#menu {
  position: absolute;
  top: 10px;
  left: 10px;
  cursor: pointer;
}
.bar {
  width: 30px;
  height: 5px;
  background-color: #333;
  margin: 6px 0;
}
#nav {
  background-color: #333;
  color: #fff;
  padding: 10px;
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  position: absolute;
  top: 50px;
  left: 10px;
  z-index: 1; /* Ensure menu is above other content */
}
#nav a {
  color: #fff;
  text-decoration: none;
  margin-bottom: 5px;
}
.registration-form {
  max-width: 400px;
  width: 100%;
  padding: 20px;
  background-color: #F9F9F9;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  margin-bottom: 20px;
  text-align: center;
}
.registration-form h2 {
  margin-bottom: 20px;
}
.registration-form form {
  display: flex;
  flex-direction: column;
}
.registration-form label {
  margin-bottom: 5px;
}
.registration-form input {
  padding: 10px;
  margin-bottom: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
  width: calc(100% - 22px);
}
.registration-form button {
  padding: 12px;
  background-color: #007BFF;
  color: #fff;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  width: 100%;
  transition: background-color 0.3s;
}
.registration-form button:hover {
  background-color: #0056B3;
}
</style>