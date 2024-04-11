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
        { name: "Ice cream cone (5 hours)", image: "src/assets/Images/FluffCone_HERO_071422_071422_37221.jpeg" },
        { name: "Vinyl sticker (5 hours)", image: "src/assets/Images/81Tz4mgmZlL._UF894,1000_QL80_.jpg" },
        { name: "Journal (10 hours)", image: "src/assets/Images/What-is-journal-writing-image-of-blank-journal.jpg" },
        { name: "Watercolor Paints (10 hours)", image: "placeholder" },
        { name: "Kite (15 hours)", image: "src/assets/Images/International-Kite-Day-1200x834.jpg" },
        { name: "Puzzle (15 hours)", image: "placeholder" },
        { name: "Lego Set (20 hours)", image: "placeholder" },
        { name: "Book Store Gift Card (20 hours)", image: "placeholder" }
      ]
    };
  }
}
    </script>
  