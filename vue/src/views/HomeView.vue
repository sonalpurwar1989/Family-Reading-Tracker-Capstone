<template>
  <div class="home">
    <h1>Home</h1>
    <p class="welcome-text">Welcome to Bookworm Buddies</p>
    <p class="subtext">Family Reading Tracker</p>
    <img class="library-image" src="@/assets/Images/_4802ec2d-e5f5-454a-8d57-6569c878c3f1.jpg" alt="Library Name">
    <div class="button-container">
      <button class="main-button">Book Search</button>
      <router-link :to="{ name: 'milestones'}">
      <button class="main-button">Milestones</button>
    </router-link>
    <router-link :to="{ name: 'prizes'}" >
    
      <button class="main-button">Prizes</button>
    </router-link>
      <div class="start-stop-buttons">
        <button class="secondary-button">Start</button>
        <button class="secondary-button">Stop</button>
      </div>
    </div>
  </div>
</template>
<script>
export default {
};
</script>
<style scoped>
.home {
  text-align: center;
  margin-top: 50px;
}
.welcome-text {
  font-size: 24px;
  font-weight: bold;
  margin-bottom: 10px;
  text-align: center;
  text-decoration: underline;
}
.subtext {
  font-size: 18px;
  margin-bottom: 20px;
}
.library-image {
  position: absolute;
  top: 40px;
  right: 40px;
  max-width: 200px;
}
.button-container {
  margin-top: 50px;
}
.main-button {
  margin: 0 10px;
  padding: 10px 20px;
  font-size: 16px;
  background-color: #4CAF50;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}
.secondary-button {
  margin: 0 5px;
  padding: 5px 10px;
  font-size: 14px;
  background-color: #2196F3;
  color: white;
  border: none;
  border-radius: 3px;
  cursor: pointer;
}
.start-stop-buttons {
  margin-top: 20px;
}
</style>














