<template>
  <div class="settings">
    <h1>Settings</h1>
    <div class="settings-options">
      <div class="setting-option">
        <h2>Account Information</h2>
        <p>View and edit your account information</p>
        <button @click="editAccountInfo">Edit Account</button>
      </div>
      <div class="setting-option">
        <h2>Child Accounts</h2>
        <p>View and manage child accounts</p>
        <button @click="manageChildAccounts">Manage Child Accounts</button>
      </div>
      <div class="setting-option">
        <h2>Reading Status</h2>
        <p>View reading status of children</p>
        <button @click="viewReadingStatus">View Reading Status</button>
      </div>
      <div class="setting-option">
        <h2>Prize Approvals</h2>
        <p>Approve prize purchases from child accounts</p>
        <button @click="approvePrizes">Approve Prizes</button>
      </div>
      <div class="setting-option">
        <h2>Manual Time Additions</h2>
        <p>Approve manual time additions for child accounts</p>
        <button @click="approveTimeAdditions">Approve Time Additions</button>
      </div>
    </div>
    <!-- Home button -->
    <router-link to="/">
      <button class="home-button">Home</button>
    </router-link>
  </div>
</template>
<script>
export default {
  methods: {
    editAccountInfo() {
      // Placeholder for logic to edit account information
      console.log("Editing account information");
    },
    manageChildAccounts() {
      // Placeholder for logic to manage child accounts
      console.log("Managing child accounts");
    },
    viewReadingStatus() {
      // Placeholder for logic to view reading status
      console.log("Viewing reading status");
    },
    approvePrizes() {
      // Placeholder for logic to approve prize purchases
      console.log("Approving prizes");
    },
    approveTimeAdditions() {
      // Placeholder for logic to approve manual time additions
      console.log("Approving time additions");
    }
  }
};
</script>
<style scoped>
.settings {
  /* Gradient background */
  background: linear-gradient(to bottom right, #FFA69E, #72CC86);
  /* Other styles */
  padding: 20px;
  text-align: center;
}
.settings h1 {
  font-size: 24px;
  margin-bottom: 20px;
  color: #4A4E69; 
}
.setting-option {
  border: 1px solid #ccc;
  border-radius: 5px;
  padding: 20px;
  margin-bottom: 20px;
  background-color: #E9D8A6; 
}
.setting-option h2 {
  font-size: 20px;
  margin-bottom: 10px;
  color: #4A4E69; 
}
.setting-option p {
  margin-bottom: 10px;
  color: #4A4E69; 
}
.setting-option button {
  padding: 10px 20px;
  font-size: 16px;
  background-color: #564787; 
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.3s;
}
.setting-option button:hover {
  background-color: #FF847C; 
}
/* Home button styles */
.home-button {
  margin-top: 20px;
  padding: 10px 20px;
  font-size: 16px;
  background-color: #007BFF; 
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.3s;
}
.home-button:hover {
  background-color: #0056B3; 
}
</style>