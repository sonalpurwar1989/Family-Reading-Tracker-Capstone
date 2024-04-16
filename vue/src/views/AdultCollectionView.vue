<template>
    <div class="adult-collection">
      <h1>Adult Collection View</h1>
      </div>
  </template>
  
  <script>
 
  </script>
  
  <style scoped>
  .adult-collection {
    text-align: center;
    padding: 50px;
    color: white;
  }
  .book-list {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
  }
  .book-item {
    margin: 20px;
  }
  .book-details {
    display: flex;
    align-items: center;
  }
  .book-image {
    width: 100px;
    height: 150px;
    border-radius: 8px;
    margin-right: 20px;
    border: 2px solid #3498DB; /* Add border to improve readability */
    box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
  }
  .remove-book-button {
    padding: 8px 12px;
    font-size: 14px;
    background-color: #E74C3C; /* Alizarin */
    color: white;
    border: none;
    border-radius: 8px;
    cursor: pointer;
    transition: background-color 0.3s ease;
  }
  .remove-book-button:hover {
    background-color: #C0392B; /* Pomegranate */
  }
  </style>
  