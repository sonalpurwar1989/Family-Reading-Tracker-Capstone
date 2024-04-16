<template>
    <div class="my-reading-nook">
      <!-- Main content -->
      <div class="container">
        <h1>My Reading Nook</h1>
        
        
        
        <!-- Minute bank -->
        <button class="minute-bank-button">{{ readingMinutes }} min</button>
      </div>
    </div>
  </template>
  
  <script>
 
  
    
  </script>
  
  <style scoped>
  /* Main content styles */
  .container {
    text-align: center;
    padding: 50px;
  }
  
  h1 {
    font-size: 36px;
    margin-bottom: 20px;
    color: white;
  }
  
  /* Book results container styles */
  .book-results {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
  }
  
  /* Book item styles */
  .book-item {
    margin: 20px;
  }
  
  /* Book info styles */
  .book-info {
    position: relative;
  }
  
  /* Remove button styles */
  .remove-button {
    position: absolute;
    top: 5px;
    right: 5px;
    padding: 6px 10px;
    font-size: 12px;
    background-color: #FF6B6B;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s ease;
  }
  .remove-button:hover {
    background-color: #FF5252;
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
  }
  .minute-bank-button:hover {
    background-color: #27AE60;
  }
  </style>
  