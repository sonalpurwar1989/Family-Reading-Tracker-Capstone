<template>
  <div class="prizes-view">
    <h1>Lets Worm Out For Some Prizes!!</h1>
    <ul>
      <li v-for="prize in prizes" :key="prize.name" class="prize-item">
        <h2>{{ prize.name }}</h2>
        <img v-if="prize.image" :src="prize.image" alt="Prize Image" class="prize-image">
      </li>
    </ul>
  </div>
</template>
<script>
export default {
  data() {
    return {
      prizes: [
        { name: "Ice cream cone (5 hours)", image: "@/assets/Images/ice_cream_cone.jpg" },
        { name: "Vinyl sticker (5 hours)", image: "@/assets/Images/vinyl_sticker.jpg" },
        { name: "Journal (10 hours)", image: "@/assets/Images/journal.jpg" },
        { name: "Watercolor Paints (10 hours)", image: "@/assets/Images/watercolor_paints.jpg" },
        { name: "Kite (15 hours)", image: "@/assets/Images/kite.jpg" },
        { name: "Puzzle (15 hours)", image: "@/assets/Images/puzzle.jpg" },
        { name: "Lego Set (20 hours)", image: "@/assets/Images/lego_set.jpg" },
        { name: "Book Store Gift Card (20 hours)", image: "@/assets/Images/book_store_gift_card.jpg" }
      ]
    };
  }
};
</script>
<style scoped>
.prizes-view {
  background-color: #F0F4F8; 
  text-align: center;
  padding: 50px;
}
h1 {
  color: #2E4369; 
  font-size: 36px;
  margin-bottom: 30px;
}
.prize-item {
  margin-bottom: 40px;
}
.prize-image {
  max-width: 100%;
  border-radius: 10px;
  box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
}
</style>