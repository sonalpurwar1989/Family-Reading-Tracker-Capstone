<template>
  <div class="child-collection">
    <!-- Main content -->
    <div class="container">
      <h1>My Reading Nook</h1>
    </div>
    <!-- Minute bank -->
    <button class="minute-bank-button"> min</button>
  </div>
</template>

<style scoped>
/* Main content styles */
.container {
  text-align: center;
  padding: 50px;
  /* Gradient background */
  background: linear-gradient(to bottom right, #FFD166, #6A0572);
  color: white; 
}

h1 {
  font-size: 36px;
  margin-bottom: 20px;
  font-family: 'Fredoka One', cursive; 
}

/* Minute bank button styles */
.minute-bank-button {
  position: fixed;
  top: 20px;
  right: 20px;
  padding: 12px 20px;
  font-size: 16px;
  background-color: #2ECC71; 
  color: white;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  transition: background-color 0.3s ease;
  box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1); 
}

.minute-bank-button:hover {
  background-color: #27AE60; 
}
</style>
