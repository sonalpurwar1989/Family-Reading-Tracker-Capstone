<template>
  <div class="home">
    <h1>Welcome to Bookworm Buddies</h1>
    <p class="welcome-text">Discover the joy of reading together!</p>
    <div class="image-container">
      <img class="library-image" src="@/assets/Images/_4802ec2d-e5f5-454a-8d57-6569c878c3f1.jpg" alt="Library">
    </div>
    <div class="button-container">
      <router-link :to="{ name: 'book-search' }">
        <button class="main-button">Find Books</button>
      </router-link>
      <router-link :to="{ name: 'milestones'}">
        <button class="main-button">Milestones</button>
      </router-link>
      <router-link :to="{ name: 'prizes'}">
        <button class="main-button">Prizes</button>
      </router-link>
      <div class="start-stop-buttons">
        <button class="secondary-button">Start Reading</button>
        <button class="secondary-button">Stop Reading</button>
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
  background-color: #F0F4F8;
  text-align: center;
  padding: 50px;
  font-family: 'Arial', sans-serif;
}
h1 {
  color: #2E4369;
  font-size: 36px;
  font-weight: bold;
  margin-bottom: 20px;
}
.welcome-text {
  font-size: 24px;
  color: #4A5568;
  margin-bottom: 40px;
}
.image-container {
  margin-bottom: 25px;
}
.library-image {
  max-width: 50%;
  border-radius: 10px;
  box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
}
.button-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
}
.main-button {
  margin: 0 10px 20px;
  padding: 12px 30px;
  font-size: 18px;
  background-color: #47B881;
  color: white;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}
.main-button:hover {
  background-color: #2CA774;
}
.secondary-button {
  margin: 0 10px 20px;
  padding: 10px 20px;
  font-size: 16px;
  background-color: #3182CE;
  color: white;
  border: none;
  border-radius: 6px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}
.secondary-button:hover {
  background-color: #2B6CB0;
}
</style>









