<template>
  <div id="select-user-view">
    <h1>Welcome, {{ selectedUser ? selectedUser.username : '' }}</h1>
    <p v-if="isNewUser">It looks like this is your first time logging in.</p>
    <div class="user-buttons-container">
      <div v-for="(user, index) in users" :key="index">
        <button
          class="user-button"
          :class="{ 'active': user === selectedUser }"
          @click="selectUser(user)"
        ></button>
        <div v-if="user === selectedUser && user.id === 1" class="username-label">{{ username }}</div>
      </div>
      <button class="add-user-button" @click="addUser">+</button>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      users: [],
      selectedUser: null,
      isNewUser: true,
      username: this.$store.state.user.username
    };
  },
  created() {
    // Fetch users data from API or Vuex store
    // For demonstration purposes, I'll initialize with some dummy data
    this.users = [
      { id: 1 },
      { id: 2 }
    ];
    // For demo, setting the first user as selected user
    if (this.users.length > 0) {
      this.selectedUser = this.users[0];
    }
  },
  methods: {
    selectUser(user) {
      this.selectedUser = user;
      this.isNewUser = false; // Once user selects, it's not a new user anymore
      // Redirect to appropriate page or perform other actions
    },
    addUser() {
      // Logic to add a new user
      // This can involve showing a form or other UI elements
    }
  }
};
</script>

<style scoped>
#select-user-view {
  text-align: center;
  margin-top: 50px;
  background: linear-gradient(to bottom right, #ff7e5f, #feb47b, #ffdb9e); /* Gradient background */
  padding: 50px;
  font-family: 'Arial', sans-serif;
  max-width: 800px;
  margin: auto;
  border-radius: 10px;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);
}

.user-buttons-container {
  margin-top: 30px;
  display: flex;
  justify-content: center;
}

.user-button {
  width: 100px;
  height: 100px;
  border-radius: 50%;
  border: 4px solid #FFD166;
  background-color: #FFD166;
  cursor: pointer;
  transition: all 0.3s;
  margin: 0 20px;
}

.user-button.active {
  background-color: #fff;
}

.add-user-button {
  width: 100px;
  height: 100px;
  border-radius: 50%;
  border: 4px solid #FFD166;
  background-color: #FFD166;
  color: #FFD166;
  font-size: 36px;
  margin-left: 20px;
  cursor: pointer;
  transition: all 0.3s;
}

.add-user-button:hover {
  background-color: #fff;
}
.username-label {
  font-size: 18px;
  color: #2D3142;
}
</style>
