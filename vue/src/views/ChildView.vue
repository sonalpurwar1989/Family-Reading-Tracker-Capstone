<template>
    <div class="child-view">
      <h1>Welcome to the Fun Zone!</h1>
      <p class="intro-text">Let's explore and have some fun!</p>
      <div class="image-container">
        <img src="placeholder" alt="Kids Reading">
      </div>
      <div class="button-container">
        <button class="main-button">whatever</button>
        <button class="main-button">whatever</button>
        <button class="main-button">whatever</button>
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
    font-family: 'Comic Sans MS', cursive;
  }
  h1 {
    font-size: 36px;
    color: #FF6600; 
  }
  .intro-text {
    font-size: 24px;
    color: #3366FF; 
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
    background-color: #FFCC00; 
    color: #333; 
    border: none;
    border-radius: 20px;
    cursor: pointer;
    transition: background-color 0.3s ease;
  }
  .main-button:hover {
    background-color: #FF9900; 
  }
  </style>