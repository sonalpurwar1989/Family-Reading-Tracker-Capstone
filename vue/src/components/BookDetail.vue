<template>
  
  <div id="book-block" v-if="book.isbn">
      <h4> {{book.title}}</h4>
      <img :src="book.coverURL" alt="">
  </div>
    <form @submit.prevent="submitBook">
  
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
    <button type="submit" >Add Book</button>
</form>

</template>

<script>
import BookService from '../services/BookService';
export default {
    props:['book'],
    
            methods: {
            submitBook(){
                BookService.addBook(this.book).then(() =>{
        alert('Book successfully added ')
      }).catch(error =>{
        alert('Error saving book')
      })
            }
        }
        

}

</script>

<style scoped>

#book-block {
    display: inline-block;
    vertical-align: top;
}

</style>