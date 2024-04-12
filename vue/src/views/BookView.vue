<template>
  <div class="book-view">
    <input type="text" v-model="searchQuery" @input="searchBooks" placeholder="Search by ISBN, Title, UPC" class="search-input">
    <ul class="book-list">
      <li v-for="book in books" :key="book.key" class="book-item">
        <img :src="getCoverURL(book.isbn)" class="book-cover" alt="Book Cover">
        <div class="book-details">
          <p class="book-title">{{ book.title }}</p>
          <p class="book-author">by {{ Array.isArray(book.author) ? book.author_name.join(', ') : book.author }}</p>
        </div>
      </li>
    </ul>
  </div>
</template>
<script>
import BookService from '../services/BookService';

export default {
  data() {
    return {
      searchQuery: '',
      books: []
    };
  },
  methods: {
    searchBooks() {
      // Implement the barcode search logic here -- Have to find one but hopefully it works
    },
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
  }
  
};
</script>
<style scoped>
.book-view {
  background-color: #FFF5EA; /* Light peach */
  text-align: center;
  padding: 50px;
  font-family: 'Arial', sans-serif;
}
.search-input {
  margin-bottom: 30px;
  padding: 12px;
  font-size: 18px;
  border: 2px solid #FF6F61; /* Coral border */
  border-radius: 8px;
  outline: none;
}
.search-input::placeholder {
  color: #2D3142; /* Dark blue placeholder text */
}
.book-list {
  list-style: none;
  padding: 0;
}
.book-item {
  display: flex;
  align-items: center;
  margin-bottom: 20px;
}
.book-cover {
  width: 25px;
  height: auto;
  margin-right: 20px;
  border-radius: 8px;
}
.book-details {
  text-align: left;
}
.book-title {
  font-size: 20px;
  font-weight: bold;
  margin-bottom: 5px;
  color: #FF6F61; /* Coral title text */
}
.book-author {
  font-size: 16px;
  color: #2D3142; /* Dark blue author text */
}
</style>
















