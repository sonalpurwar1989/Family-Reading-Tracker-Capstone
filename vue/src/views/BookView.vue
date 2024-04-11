<template>
  <div class="book-view">
    <input type="text" v-model="searchQuery" @input="searchBooks" placeholder="Search for books..." class="search-input">
    <ul class="book-list">
      <li v-for="book in books" :key="book.key" class="book-item">
        {{ book.title }} by {{ book.author_name.join(', ') }}
      </li>
    </ul>
  </div>
</template>
<script>
export default {
  data() {
    return {
      searchQuery: '',
      books: []
    };
  }
};
</script>
<style scoped>
.book-view {
  background-color: #F0F4F8; /* Match the background color of the HomeView page */
  text-align: center;
  padding: 50px;
}
.search-input {
  margin-bottom: 30px;
  padding: 10px;
  font-size: 16px;
  border: 1px solid #ccc;
  border-radius: 5px;
}
.book-list {
  list-style: none;
  padding: 0;
}
.book-item {
  margin-bottom: 20px;
  font-size: 18px;
}
</style>














