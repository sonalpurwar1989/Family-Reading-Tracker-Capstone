<template>
  <div class="home-view">
    <h1>Welcome to Bookworm Buddies</h1>
    <p class="intro-text">Discover the joy of reading together!</p>
    <div class="image-container">
      <img class="library-image" src="src/assets/images/worm family.jpg" alt="Library">
    </div>
    <div class="button-container">
      <router-link :to="{ name: 'prizes'}">
        <button class="main-button">Prizes</button>
      </router-link>
      <router-link :to="{ name: 'select-user'}">
        <button class="main-button">Family</button>
      </router-link>
      <!-- Book search button -->
      <router-link :to="{ name: 'book-search' }">
        <button class="main-button">Book Search</button>
      </router-link>
    </div>
    <!-- Timer and controls -->
    <div class="timer-controls">
      <input type="number" v-model="manualTime" placeholder="Enter time in minutes" class="time-input">
      <button @click="addManualTime" class="add-time-button">Add Minutes</button>
    </div>
    <div>
      <button v-if="addedMinutes !== null" class="minute-bank-button">{{ addedMinutes }} min</button>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import ReadingSessionService from '@/services/ReadingSessionService';

export default {
  data() {
    return {
      manualTime: null,
      addedMinutes: null,
    };
  },
  computed: {
    userReadingMinutes() {
      return this.$store.state.user.readingMinutes;
    }
  },
  methods: {
    addManualTime() {
      if (!this.manualTime || isNaN(parseInt(this.manualTime))) {
        alert('Please enter a valid number');
        return;
      }
      const minutesToAdd = parseInt(this.manualTime);
      
      this.$store.commit('updateUserReadingMinutes', minutesToAdd);
      
      this.saveSession(minutesToAdd);
      
      this.addedMinutes = this.addedMinutes !== null ? this.addedMinutes + minutesToAdd : minutesToAdd;
      alert(`${minutesToAdd} minutes added successfully.`);
      this.manualTime = null; 
    },
    saveSession(minutesToAdd) {
      axios.post('/reading-sessions', {
        userId: this.$store.state.user.id, 
        elapseMinutes: minutesToAdd,
      })
      .then(response => {
        console.log('Reading Session saved successfully:', response.data);
        alert('Time saved successfully');
      })
      .catch(error => {
        console.error('Error saving session:', error);
      });
    },
  },
};
</script>

<style scoped>
.home-view {
  text-align: center;
  padding: 50px;
  background: linear-gradient(to bottom right, #FFD166, #6A0572);
  color: #fff;
}
h1 {
  font-size: 36px;
  margin-bottom: 20px;
}
.intro-text {
  font-size: 24px;
  margin-bottom: 40px;
}
.image-container {
  margin-bottom: 25px;
}
.image-container img {
  max-width: 100%;
  height: auto;
}
.button-container {
  display: flex;
  justify-content: center;
}
.main-button {
  margin: 0 10px;
  padding: 12px 30px;
  font-size: 18px;
  background-color: #FFD166;
  color: #2D3142;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}
.main-button:hover {
  background-color: #FF9F51;
}
.timer-controls {
  margin-top: 30px;
}
.time-input {
  padding: 10px;
  margin-right: 10px;
  width: 150px;
  font-size: 16px;
}
.add-time-button {
  padding: 12px 30px;
  font-size: 16px;
  background-color: #FFD166;
  color: #2D3142;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}
.add-time-button:hover {
  background-color: #FF9F51;
}
.minute-bank-button {
  padding: 12px 20px;
  font-size: 16px;
  background-color: #FFD166;
  color: #2D3142;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}
.minute-bank-button:hover {
  background-color: #FF9F51;
}
</style>
