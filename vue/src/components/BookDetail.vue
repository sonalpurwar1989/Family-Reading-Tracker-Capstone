<template>
  
  <div id="book-block" v-if="book.isbn">
      <h4> {{book.title}}</h4>
      <img :src="book.coverURL" alt="">

  </div>

</template>

<script>
export default {
    props:[
        'book',
    ],

}
</script>

<style scoped>

#book-block {
    display: inline-block;
    vertical-align: top;
}

</style>