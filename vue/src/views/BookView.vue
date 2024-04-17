<template>
  <div class="home">
    <h1>Welcome to Bookworm Buddies</h1>
    <p class="welcome-text">Discover the joy of reading together!</p>
    <!-- Book search bar -->
    <div class="search-container">
      <input type="text" v-model="searchQuery" placeholder="Search for books..." class="search-input">
      <button class="search-button" v-on:click="searchBooks">Search</button>
    </div>
    <div class="book-results">
      <div v-for="book in books" :key="book.id" class="book-container">
        <book-detail :book="book" />
        <button class="add-book-button">Add Book</button>
      </div>
    </div>
    <!-- Minute bank -->
    <button class="minute-bank-button">{{ readingMinutes }} min</button>
  </div>
</template>
<script>
import BookService from '../services/BookService';
import BookDetail from '../components/BookDetail.vue';
export default {
  components: {
    BookDetail,
  },
  data() {
    return {
      readingMinutes: 0,
      searchQuery: '',
      books: []
    };
  },
  methods: {
    searchBooks() {
      const cleanText = this.searchQuery.trim();
      if (cleanText.length > 0) {
        BookService.searchBooksByTitle(cleanText)
          .then(response => {
            this.books = response.data;
          })
          .catch(error => {
            this.books = [];
            alert(error);
          });
      }
    }
  }
};
</script>
<style scoped>
/* Navigation buttons styles */
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
/* Home page styles */
.home {
  background: linear-gradient(to bottom right, #2980B9, #2C3E50);
  text-align: center;
  padding: 50px;
}
/* Heading styles */
h1 {
  font-size: 36px;
  margin-bottom: 20px;
  color: white;
}
/* Welcome text styles */
.welcome-text {
  font-size: 24px;
  margin-bottom: 40px;
  color: white;
}
/* Search bar container styles */
.search-container {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-bottom: 30px;
}
/* Search input styles */
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
/* Search button styles */
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
/* Book results container styles */
.book-results {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  gap: 20px;
}
/* Book detail component styles */
.book-container {
  margin: 20px;
  text-align: center;
}
/* Book cover styles */
.book-cover {
  text-align: center;
  margin: 15px;
  position: relative;
}
/* Book cover image styles */
.book-image {
  width: 150px;
  height: auto;
  border: 2px solid white;
  border-radius: 8px;
  box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
}
/* Add Book button styles */
.add-book-button {
  margin-top: 10px;
  padding: 12px 20px;
  font-size: 18px;
  background-color: #3498DB;
  color: white;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}
.add-book-button:hover {
  background-color: #2980B9;
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