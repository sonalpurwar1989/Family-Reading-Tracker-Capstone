<template>
    <div id="select-user-view">
      <h1>Welcome, {{ username }}</h1>
      <p>It looks like this is your first time logging in.</p>
      <div class="user-type-buttons">
        <button @click="selectAdultUser">Adult User</button>
        <router-link to="/child-view">
        <button @click="selectChildUser">Child User</button>
      </router-link>
      </div>
    </div>
  </template>
  <script>
  export default {
    data() {
      return {
        username: this.$store.state.user.username
      };
    },
    methods: {
      selectAdultUser() {
        // Logic for selecting adult user
        // Redirect to appropriate page
        this.$router.push({ name: "home" });
      }
    }
  };
  </script>
  <style scoped>
  #select-user-view {
    text-align: center;
    margin-top: 50px;
  }
  .user-type-buttons {
    margin-top: 20px;
  }
  .user-type-buttons button {
    margin: 0 10px;
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    background-color: #844CC5;
    color: #fff;
    cursor: pointer;
    transition: background-color 0.3s;
  }
  .user-type-buttons button:hover {
    background-color: #3527B1;
  }
  </style>