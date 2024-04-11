<template>
  <div class="home">
    <h1>Welcome to Bookworm Buddies</h1>
    <p class="welcome-text">Discover the joy of reading together!</p>
    <div class="image-container">
      <img class="library-image" src="src\assets\images\worm family.jpg" alt="Library">
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
      <router-link :to="{ name: 'select-user'}">
        <button class="main-button">Family</button>
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
.library-image {
  max-width: 75%;
  height: auto;
  height: auto;
  border-radius: 10px;
  box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
}
.home {
  background-color: #FFF5EA; /* Light peach */
  text-align: center;
  padding: 50px;
  font-family: 'Arial', sans-serif;
}
h1 {
  color: #FF6F61; /* Coral */
  font-size: 36px;
  font-weight: bold;
  margin-bottom: 20px;
}
.welcome-text {
  font-size: 24px;
  color: #2D3142; /* Dark blue */
  margin-bottom: 40px;
}
.image-container {
  margin-bottom: 25px;
}
.library-image {
  max-width: 50%;
  border-radius: 10px;
  box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
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
  background-color: #FFD166; /* Yellow */
  color: #2D3142; /* Dark blue */
  border: none;
  border-radius: 8px;
  cursor: pointer;
  transition: background-color 0.3s ease;
  box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
}
.main-button:hover {
  background-color: #FF9F51; /* Orange */
}
.secondary-button {
  margin: 0 10px 20px;
  padding: 10px 20px;
  font-size: 16px;
  background-color: #6A0572; /* Purple */
  color: white;
  border: none;
  border-radius: 6px;
  cursor: pointer;
  transition: background-color 0.3s ease;
  box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
}
.secondary-button:hover {
  background-color: #FF4E00; /* Red */
}
</style>