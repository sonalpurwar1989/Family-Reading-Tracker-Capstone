<template>
  <div id="select-user-view">
    <h1>Welcome, {{ signedInUser.username }}</h1>
    <p v-if="isNewUser">It looks like this is your first time logging in.</p>
    <div class="user-buttons-container">
      <div v-for="(user, index) in users" :key="index">
        <div class="user-button-container">
          <router-link :to="user.isChild ? '/child-view' : '/'">
            <button
              class="user-button"
              :class="{ 'active': user === selectedUser }"
            >
              <div class="username-label">{{ user.username }}</div>
            </button>
          </router-link>
        </div>
      </div>
      <button class="add-user-button" @click="showAddUserModal">+</button>
    </div>
    <!-- Add user modal -->
    <div v-if="showModal" class="modal">
      <div class="modal-content">
        <h2>Add New User</h2>
        <input type="text" v-model="newUsername" placeholder="Enter username" />
        <label><input type="radio" v-model="userType" value="adult" /> Adult</label>
        <label><input type="radio" v-model="userType" value="child" /> Child</label>
        <div class="modal-buttons">
          <button class="modal-button" @click="addUser">Add User</button>
          <button class="modal-button" @click="closeModal">Cancel</button>
        </div>
      </div>
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
      showModal: false,
      newUsername: '',
      userType: '',
      signedInUser: this.$store.state.user // Assuming signed-in user data is stored in Vuex state
    };
  },
  created() {
    this.fetchUsers();
    if (this.users.length > 0) {
      this.selectedUser = this.users[0];
    }
  },
  watch: {
    selectedUser() {
      /*this.greetUser();*/
    }
  },
  methods: {
    async fetchUsers() {
      this.users = [
        { id: 1, username: this.signedInUser.username, isChild: false }
      ];
    },
    selectUser(user) {
      this.selectedUser = user;
      this.isNewUser = false;
    },
    /*greetUser() {
      if (this.selectedUser) {
        alert(`Hi, ${this.selectedUser.username}!`);
      }
    },*/
    showAddUserModal() {
      this.showModal = true;
    },
    closeModal() {
      this.showModal = false;
      this.newUsername = '';
      this.userType = '';
    },
    addUser() {
      if (this.newUsername && this.userType) {
        const newUser = {
          id: this.users.length + 1,
          username: this.newUsername,
          isChild: this.userType === 'child'
        };
        this.users.push(newUser);
        this.selectedUser = newUser;
        this.isNewUser = false;
        this.closeModal();
      } else {
        alert("Please enter a username and select user type.");
      }
    }
  }
};
</script>
<style scoped>
#select-user-view {
  text-align: center;
  margin-top: 50px;
  padding: 50px;
  font-family: 'Arial', sans-serif;
  max-width: 800px;
  margin: auto;
  border-radius: 10px;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);
  background: linear-gradient(to bottom right, #FF7E5F, #FEB47B, #FFDB9E);
}
.user-buttons-container {
  margin-top: 30px;
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
}
.user-button-container {
  margin-bottom: 20px;
}
.user-button {
  position: relative;
  width: 100px;
  height: 100px;
  border-radius: 50%;
  border: 4px solid #9DC3FF;
  cursor: pointer;
  transition: all 0.3s;
  background: radial-gradient(circle, #9DC3FF, #7AA8FF);
}
.user-button.active {
  background-color: #fff;
}
.user-button .username-label {
  position: absolute;
  bottom: -25px;
  left: 50%;
  transform: translateX(-50%);
  font-size: 12px;
  font-weight: bold;
  color: #fff;
  background-color: rgba(0, 0, 0, 0.7);
  padding: 5px 10px;
  border-radius: 5px;
}
.user-button:hover {
  transform: scale(1.5);
}
.add-user-button {
  position: relative;
  width: 100px;
  height: 100px;
  border-radius: 50%;
  border: 4px solid #9DC3FF;
  cursor: pointer;
  transition: all 0.3s;
  background: radial-gradient(circle, #9DC3FF, #7AA8FF);
}
.add-user-button.active {
  background-color: #fff;
}
.add-user-button:after {
  content: "+";
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  color: #fff;
}
.add-user-button:before {
  content: "Add User";
  position: absolute;
  top: calc(100% + 5px);
  left: 50%;
  transform: translateX(-50%);
  font-size: 12px;
  font-weight: bold;
  color: #fff;
  background-color: rgba(0, 0, 0, 0.7);
  padding: 5px 10px;
  border-radius: 5px;
}
.add-user-button:hover {
  transform: scale(1.5);
}
.modal {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  display: flex;
  justify-content: center;
  align-items: center;
}
.modal-content {
  background-color: #fff;
  padding: 20px;
  border-radius: 10px;
}
.modal-content h2 {
  margin-top: 0;
}
.modal-content input[type="text"],
.modal-content input[type="radio"] {
  margin: 10px 0;
}
.modal-buttons {
  margin-top: 20px;
  text-align: center;
}
.modal-button {
  padding: 10px 20px;
  margin: 0 10px;
  border: none;
  border-radius: 5px;
  background-color: #FFD166;
  color: #fff;
  cursor: pointer;
}
.modal-button:hover {
  background-color: #FFB74D;
}
</style>
