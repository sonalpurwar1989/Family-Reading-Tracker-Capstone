<template>
<div v-if="displayBook.isbn">
  <div id="book-block">
    <h4>{{ displayBook.title }}</h4>
    <img class="book-cover" :src="displayBook.coverURL" alt="" />
  </div>
  <form @submit.prevent="submitBook" >
    <!-- <label for="title">Title:</label> 
    <input id="title" v-model="book.title" placeholder="Enter Book Title" > -->
    <div>
      <!-- <label for="author">Author:</label>
        <input id="author" v-model="book.author" placeholder="= Enter Author Name" > -->
    </div>
    <div>
      <!--  <label for="isbn">ISBN:</label>
        <input id="isbn" v-model="book.isbn" placeholder="Enter Isbn Number" > -->
    </div>
    <button id="btn-add-book" class="add-book-button" type="submit" v-if="!addDisabled">Add Book</button>
  </form>
  </div>
</template>

<script>
import ReadingSessionService from '@/services/ReadingSessionService';
import BookService from "../services/BookService";
export default {
  props: ["book", "addDisabled"],

  data() {
    return{
      displayBook: {}

    }
  },

  mounted() {

    this.displayBook = this.book;

  },

  

  methods: {
    submitBook() {
      BookService.addBook(this.book)
        .then(() => {
          this.displayBook = {};
        })
        .catch((error) => {
          alert("Error saving book");
        });
    },
    
  },
};
</script>

<style scoped>
#book-block {
  display: inline-block;
  vertical-align: top;
}
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

.book-cover {

  min-height: 300px;
  min-width: 120px;

}
</style>