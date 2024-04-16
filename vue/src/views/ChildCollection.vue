<template>
    <div class="my-reading-nook">
      <!-- Main content -->
      <div class="container">
        <h1>My Reading Nook</h1>
        
        <!-- Book display -->
        <div class="book-results">
          <div v-for="book in books" :key="book.id" class="book-item">
            <div class="book-info">
              <book-detail :book="book" />
              <button @click="removeBook(book.id)" class="remove-button">Remove</button>
            </div>
          </div>
        </div>
        
        <!-- Minute bank -->
        <button class="minute-bank-button">{{ readingMinutes }} min</button>
      </div>
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
        books: [] 
      };
    },
    methods: {
      // Method to fetch and display the child's added books
      fetchBooks() {
        // Call BookService to fetch books for the child
        BookService.getChildBooks().then(response => {
          this.books = response.data;
        }).catch(error => {
          console.error('Error fetching books:', error);
        });
      },
      // Method to remove a book from the list
      removeBook(bookId) {
        // Call BookService to remove the book
        BookService.removeBook(bookId).then(response => {
          // Filter out the removed book from the list
          this.books = this.books.filter(book => book.id !== bookId);
        }).catch(error => {
          console.error('Error removing book:', error);
        });
      }
    },
    mounted() {
      // Fetch and display the child's books when the component is mounted
      this.fetchBooks();
    }
  };
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
  