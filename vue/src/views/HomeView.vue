<template>
  <div class="home-view">
    <h1>Welcome to Bookworm Buddies</h1>
    <p class="intro-text">Discover the joy of reading together!</p>
    <div class="image-container">
      <img class="library-image" src="src\assets\images\worm family.jpg" alt="Library">
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
      <button @click="toggleTimer" class="main-button">{{ timerRunning ? 'All Finished' : 'Time to Read!' }} </button>
    </div>
    <router-link :to="{ name: 'adult-collection'}">
      <button class="secondary-button">Book Collection</button>
    </router-link>
    <!-- Minute bank -->
    <button class="minute-bank-button">{{ readingMinutes }} min</button>
    <select v-model="selectedUser" required>
      <option v-for="user in users" :key="user.id" :value="user.id">{{ user.username }}</option>
    </select>
    <div>
      <span>{{ elapseMinutes }} </span>
    </div>
  </div>
</template>
<script>
import axios from 'axios';
import ReadingSessionService from '@/services/ReadingSessionService';
export default {
  data() {
    return {
      timerRunning: false,
      readingMinutes: 0,
      timer: null,
      elapseMinutes: 0,
      selectedUser: '',
    };
  },
  methods: {
    toggleTimer() {
      if (this.timerRunning) {
        this.stopTimer();
      } else {
        this.startTimer();
      }
    },
    startTimer() {
      this.startTime = Date.now();
      this.timer = setInterval(() => {
        this.elapseMinutes = Math.floor((Date.now() - this.startTime) / 60000);
      }, 1000); // 1 minute interval
    },
    stopTimer() {
      clearInterval(this.timer);
      this.timer = null;
    },
    saveSession() {
      axios.post('/reading-sessions', {
        userId: this.selectedUser,
        elapseMinutes: this.elapseMinutes,
      })
      .then(response => {
        alert('time saved');
      })
      .catch(error => {
        console.error('Error saving session:', error);
      });
      ReadingSessionService.createReadingSession({
        userId: this.selectedUser,
        durationMinutes: this.elapseMinutes,
      })
      .then(() =>{
        alert('session saved successfully');
        this.elapseMinutes = 0; // Reset the timer
      })
      .catch(error => {
        console.error('Error creating reading session:', error);
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
.secondary-button {
  margin: 0 10px;
  padding: 10px 20px;
  font-size: 16px;
  background-color: #6A0572;
  color: white;
  border: none;
  border-radius: 6px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}
.secondary-button:hover {
  background-color: #FF4E00;
}
.timer-controls {
  margin-top: 30px;
}
.minute-bank-button {
  position: fixed;
  top: 20px;
  right: 20px;
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