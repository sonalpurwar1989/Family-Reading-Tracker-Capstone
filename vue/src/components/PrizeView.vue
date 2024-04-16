<template>
  <div class="prize-view">
    <div class="nav">
      
      
    </div>
    <div class="prize-type" v-for="(prizeGroup, index) in prizeGroups" :key="index">
      <h2>{{ prizeGroup.type }}</h2>
      <div class="prize-list">
        <div v-for="(prize, prizeIndex) in prizeGroup.prizes" :key="prizeIndex" class="prize-item">
          <img :src="prize.image" alt="Prize Image" class="prize-image">
          <div class="prize-details">
            <p class="prize-name">{{ prize.name }}</p>
            <p class="prize-hours">{{ prize.hours }} hours</p>
            <button @click="purchasePrize(prize)" class="prize-button">Purchase</button>
            <button @click="editPrize(prize)" class="prize-button">Edit</button>
            <button @click="removePrize(prize)" class="prize-button">Remove</button>
          </div>
        </div>
      </div>
    </div>
    <div class="add-prize-container">
      <input type="text" v-model="newPrize.name" placeholder="Enter prize name" class="prize-input">
      <input type="number" v-model="newPrize.hours" placeholder="Enter hours" class="prize-input">
      <button @click="addPrize" class="add-prize-button">Add Prize</button>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      prizes: [
        { name: "Gamestop Giftcard", hours: 10, image: "src/assets/images/playnite_icon_rotane.png" },
        { name: "Robux", hours: 20, image: "src/assets/images/Roblox Logo (Converted To PNG).PNG" },
        { name: "V-Bucks", hours: 20, image: "src/assets/images/5-icone-fortnite.png" },
        { name: "Playstation Giftcard", hours: 25, image: "src/assets/images/playstation_icon_rotane.png" },
        { name: "Xbox Giftcard", hours: 25, image: "src/assets/images/xbox_icon_rotane.png" },
        { name: "Steam Giftcard", hours: 30, image: "src/assets/images/steam_icon_rotane.png" },
        { name: "Nintendo Giftcard", hours: 30, image: "src/assets/images/switch_icon_rotane.png" },
        { name: "Amazon Giftcard", hours: 35, image: "src/assets/images/amazon_logo_icon_by_effuuuuuuuu_dg8eaic.png" },
        { name: "Starbucks Giftcard", hours: 35, image: "src/assets/images/Starbucks.png" },
        { name: "Ice cream cone", hours: 5, image: "src/assets/images/ice-cream.png" },
        { name: "Vinyl sticker", hours: 5, image: "src/assets/images/bookworm-sticker.png" },
        { name: "Journal", hours: 10, image: "src/assets/images/journal.png" },
        { name: "Watercolor Paints", hours: 10, image: "src/assets/images/watercolor.png" },
        { name: "Kite", hours: 15, image: "src/assets/images/kite.png" },
        { name: "Puzzle", hours: 15, image: "src/assets/images/puzzle.png" },
        { name: "Lego Set", hours: 20, image: "src/assets/images/lego.png" },
        { name: "Book Store Gift Card", hours: 20, image: "src/assets/images/books__1_png_by_shadowplay_gfx_dfwowcf.png" }
      ],
      newPrize: {
        name: "",
        hours: null,
        image: "src/assets/images/fireworks_2_by_daxxe_d2uww7c.jpg"
      }
    };
  },
  computed: {
    prizeGroups() {
      const groups = {};
      this.prizes.forEach(prize => {
        if (!groups[prize.hours]) {
          groups[prize.hours] = { type: `${prize.hours} hours`, prizes: [] };
        }
        groups[prize.hours].prizes.push(prize);
      });
      return Object.values(groups);
    }
  },
  methods: {
    addPrize() {
      if (this.newPrize.name && this.newPrize.hours) {
        this.prizes.push({ ...this.newPrize });
        this.newPrize.name = "";
        this.newPrize.hours = null;
      }
    },
    purchasePrize(prize) {
      // Logic to deduct reading minutes and grant prize
      console.log("Purchased:", prize);
    },
    editPrize(prize) {
      // Logic to edit prize details
      console.log("Edited:", prize);
    },
    removePrize(prize) {
      // Logic to remove prize
      console.log("Removed:", prize);
    },
    goHome() {
      // Logic to navigate to home
      console.log("Go Home");
    },
    logout() {
      // Logic to logout
      console.log("Logout");
    }
  }
};
</script>
<style scoped>
.prize-view {
  text-align: center;
  padding: 50px;
  font-family: 'Arial', sans-serif;
  background: linear-gradient(to bottom right, #1bbd43, #143cf1);
}
.nav {
  position: absolute;
  top: 20px;
  left: 20px;
}
.home-button, .logout-button {
  margin: 0 10px;
  padding: 8px 12px;
  font-size: 16px;
  border: none;
  border-radius: 8px;
  background: linear-gradient(to bottom right, #6A0572, #96ff66);
  color: white;
  cursor: pointer;
  transition: background-color 0.3s ease;
}
.home-button:hover, .logout-button:hover {
  background: linear-gradient(to bottom right, #FFD166, #6A0572);
}
.prize-type {
  margin-bottom: 40px;
}
.prize-list {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
}
.prize-item {
  margin: 20px;
  border: 1px solid #ccc;
  border-radius: 10px;
  padding: 10px;
  display: flex;
  align-items: center;
  max-width: 200px;
}
.prize-image {
  width: 50px;
  height: 50px;
  border-radius: 50%;
  margin-right: 10px;
}
.prize-details {
  text-align: left;
}
.prize-name {
  font-weight: bold;
}
.prize-hours {
  margin-bottom: 5px;
  color: #666;
}
.prize-button {
  margin-top: 10px;
  padding: 12px 30px;
  font-size: 18px;
  background-color: #0beb70;
  color: #f6f3f8;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}
.prize-button:hover {
  background-color: #0e5dc5;
}
.add-prize-container {
  display: flex;
  align-items: center;
  justify-content: center;
}
.prize-input {
  margin: 10px;
  padding: 10px;
  font-size: 16px;
  border: 2px solid #2d7ea3;
  border-radius: 8px;
  outline: none;
}
.add-prize-button {
  padding: 12px 30px;
  font-size: 18px;
  background-color: #18ac13;
  color: white;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  transition: background-color 0.3s ease;
  margin: 0 10px;
}
.add-prize-button:hover {
  background-color: #96143f;
}
</style>



