<template>
  <div class="home">
    <!-- Navigation -->
    <div class="nav">
      <router-link :to="{ name: 'home' }">
        <button class="home-button">Home</button>
      </router-link>
      <router-link :to="{ name: 'settings' }">
        <button class="settings-button">Settings</button>
      </router-link>
      <router-link :to="{ name: 'logout' }">
        <button class="logout-button">Logout</button>
      </router-link>
    </div>
    
    <h1>Welcome to Bookworm Buddies</h1>
    <p class="welcome-text">Discover the joy of reading together!</p>
    <!-- Book search bar -->
    <div class="search-container">
      <input type="text" v-model="searchQuery" @input="searchBooks" placeholder="Search for books..." class="search-input">
      <router-link :to="{ name: 'book-search', query: { search: searchQuery } }">
        <button class="search-button">Search</button>
      </router-link>
    

    </div>
    <!-- Minute bank -->
    <button class="minute-bank-button">{{ readingMinutes }} min</button>
  </div>
</template>
<script>
import BookService from '../services/BookService';

export default {
  data() {
    return {
      readingMinutes: 0,
      searchQuery: '',
      books: [] 
    };
  },
  methods: {
    async searchBooks() {
      // Placeholder for API call to fetch books based on search query
      // 
    },
<<<<<<< HEAD
    getCoverURL(isbn) {
      return `https://covers.openlibrary.org/b/isbn/${isbn}-S.jpg`;
    },
    
    getAllBooks() {
      // TODO - Get data from API and set `topics` property
      BookService.getAllBooks()
      .then(response => {
        console.log(response.data);
        this.books = response.data;
      });
  }
  
  },
  created() {
    this.getAllBooks();
=======
    // Placeholder for API call to fetch books from the server
    // 
    //   
    //    
    //     
    //   
    //     
    //   
    // 
>>>>>>> 9355d33f5f41e2df826da63b67b4bf94a37fce85
  }
  
};
</script>
<style scoped>

.home-button,
.settings-button,
.logout-button {
  margin: 0 10px;
  padding: 8px 12px;
  font-size: 16px;
  border: none;
  border-radius: 8px;
  background-color: #2ECC71; 
  color: white;
  cursor: pointer;
  transition: background-color 0.3s ease;
}
.home-button:hover,
.settings-button:hover,
.logout-button:hover {
  background-color: #27AE60; 
}

.home {
  /* Gradient background */
  background: linear-gradient(to bottom right, #2980B9, #2C3E50);
  
  text-align: center;
  padding: 50px;
}
h1 {
  font-size: 36px;
  margin-bottom: 20px;
  color: white;
}
.welcome-text {
  font-size: 24px;
  margin-bottom: 40px;
  color: white;
}
.search-container {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-bottom: 30px;
}
.search-input {
  padding: 12px;
  font-size: 18px;
  border: 2px solid #3498DB; 
  border-radius: 8px;
  outline: none;
}
.search-input::placeholder {
  color: #ECF0F1; 
}
.search-button {
  margin-left: 10px;
  padding: 12px 20px;
  font-size: 18px;
  background-color: #2ECC71; 
  color: white;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  transition: background-color 0.3s ease;
  box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
}
.search-button:hover {
  background-color: #27AE60; 
}
.book-covers {
  display: flex;
  justify-content: center;
  flex-wrap: wrap;
}
.book-cover {
  margin: 20px;
}
.book-image {
  max-width: 150px; 
  
  border-radius: 8px;
  box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
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