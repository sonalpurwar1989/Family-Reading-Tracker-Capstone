<template>
  <div class="child-view">
    <h1>Welcome to the Fun Zone!</h1>
    <p class="intro-text">Let's explore and have some fun!</p>
    <div class="image-container">
      <img class="library-image" src="src\assets\images\worm family.jpg" alt="Library">
    </div>
    <div class="button-container">
      <router-link :to="{ name: 'book-search' }">
        <button class="main-button">Find a Book</button>
      </router-link>
      <router-link :to="{ name: 'child-collection' }">
        <button class="main-button">My Books</button>
      </router-link>
      <router-link :to="{ name: 'prizes'}">
        <button class="main-button">Prizes</button>
      </router-link>
    </div>
  </div>
</template>

<script>
export default {
  name: 'ChildView'
};
</script>

<style scoped>
.child-view {
  text-align: center;
  padding: 50px;
  font-family: 'Arial', sans-serif;
  background: linear-gradient(to bottom right, #70C1B3, #8360C3); 
  color: #fff; 
}

h1 {
  font-size: 36px;
  margin-bottom: 20px;
  font-weight: bold; 
}

.intro-text {
  font-size: 24px;
  margin-bottom: 40px;
}

.image-container {
  margin-bottom: 50px;
}

.image-container img {
  max-width: 100%;
  height: auto;
}

.button-container {
  display: flex;
  justify-content: center;
}

.main-button {
  margin: 0 10px;
  padding: 15px 30px;
  font-size: 18px;
  background-color: #60A4B8; 
  color: #fff;
  border: none;
  border-radius: 20px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.main-button:hover {
  background-color: #7DA0B5; 
}
</style>
