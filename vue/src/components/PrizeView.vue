<template>
    <h1>Lets Worm Out For Some Prizes!!</h1>
    <ul>
        <li v-for="prize in prizes" :key="prize.name">
            <h2> {{ prize.name }}</h2>
            <img v-if = "prize.image" :src="prize.image" alt="Prize Image">
            </li>
    </ul>

   



    

  </template>

  
  <script>
   export default{
  data(){
    return {
      prizes: [
        { name: "Ice cream cone (5 hours)", image: "placeholder" },
        { name: "Vinyl sticker (5 hours)", image: "placeholder" },
        { name: "Journal (10 hours)", image: "placeholder" },
        { name: "Watercolor Paints (10 hours)", image: "placeholder" },
        { name: "Kite (15 hours)", image: "placeholder" },
        { name: "Puzzle (15 hours)", image: "placeholder" },
        { name: "Lego Set (20 hours)", image: "placeholder" },
        { name: "Book Store Gift Card (20 hours)", image: "placeholder" }
      ]
    };
  }
}
    </script>
  