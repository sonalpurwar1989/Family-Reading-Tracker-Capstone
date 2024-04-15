<template>
  
  <div id="book-block" v-if="book.isbn">
      <h4> {{book.title}}</h4>
      <img :src="book.coverURL" alt="">

    <form @submit.prevent="submitBook"></form>
    </div>
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

</template>

<script>
export default {
    props:['book'],
    
            methods: {
            submitBook(){
                this.$emit('save-book', this.book)
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