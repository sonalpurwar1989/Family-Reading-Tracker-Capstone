<template>
    <div>
      <input type="text" v-model="searchQuery" @input="searchBooks" placeholder="Search for books...">
      <ul>
        <li v-for="book in books" :key="book.key">
          {{ book.title }} by {{ book.author_name.join(', ') }}
        </li>
      </ul>
    </div>
  </template>
  <script>
  
 
  </script>
  <style scoped>
  /* Add your component's styles here */
  </style>