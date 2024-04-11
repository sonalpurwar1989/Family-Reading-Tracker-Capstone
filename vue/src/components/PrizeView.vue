<template>
  <div class="prize-view">
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
      <label for="image-upload" class="file-upload">
        <span>Choose Image</span>
        <input id="image-upload" type="file" @change="onFileChange" accept="image/*" class="prize-input">
      </label>
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
        image: null
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
      if (this.newPrize.name && this.newPrize.hours && this.newPrize.image) {
        this.prizes.push({ ...this.newPrize });
        this.newPrize.name = "";
        this.newPrize.hours = null;
        this.newPrize.image = null;
      }
    },
    onFileChange(e) {
      const file = e.target.files[0];
      if (file) {
        const reader = new FileReader();
        reader.onload = (e) => {
          this.newPrize.image = e.target.result;
        };
        reader.readAsDataURL(file);
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
    }
  }
};
</script>
<style scoped>
.prize-view {
  background-color: #FFF5EA; /* Light peach */
  text-align: center;
  padding: 50px;
  font-family: 'Arial', sans-serif;
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
  background-color: #FFD166; /* Yellow */
  color: #2D3142; /* Dark blue */
  border: none;
  border-radius: 8px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}
.prize-button:hover {
  background-color: #FF9F51; /* Orange */
}
.add-prize-container {
  margin-top: 40px;
  display: flex;
  align-items: center;
  justify-content: center;
}
.prize-input {
  margin: 10px;
  padding: 10px;
  font-size: 16px;
  border: 2px solid #47B881; /* Light green */
  border-radius: 8px;
  outline: none;
}
.add-prize-button, .file-upload {
  padding: 12px 30px;
  font-size: 18px;
  background-color: #6A0572; /* Purple */
  color: white;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  transition: background-color 0.3s ease;
  margin: 0 10px; /* Adjust the spacing between the buttons */
}
.add-prize-button:hover, .file-upload:hover {
  background-color: #FF4E00; /* Red */
}
.file-upload input[type="file"] {
  position: absolute;
  top: 0;
  right: 0;
  margin: 0;
  padding: 0;
  font-size: 20px;
  cursor: pointer;
  opacity: 0;
}
</style>