<template>
  <div class="adult-collection">
    <h1>Adult Collection View</h1>
    <div class="book-list">
      <div class="book-item">
        <div class="book-details">
          <img class="book-image" src="book1.jpg" alt="Book 1">
          <button class="remove-book-button">Remove</button>
        </div>
        <p class="book-title">Book 1 Title</p>
      </div>
      <div class="book-item">
        <div class="book-details">
          <img class="book-image" src="book2.jpg" alt="Book 2">
          <button class="remove-book-button">Remove</button>
        </div>
        <p class="book-title">Book 2 Title</p>
      </div>
      
    </div>
  </div>
</template>

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
  border: 2px solid #3498DB; 
  box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
}

.remove-book-button {
  padding: 8px 12px;
  font-size: 14px;
  background-color: #E74C3C; 
  color: white;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.remove-book-button:hover {
  background-color: #C0392B; 
}

.book-title {
  color: #3498DB;
  font-size: 16px;
  margin-top: 10px;
}
</style>
