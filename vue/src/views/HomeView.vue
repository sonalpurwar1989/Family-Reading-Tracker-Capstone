<template>
  <div class="home">
    
    <!-- Main content -->
    <h1>Welcome to Bookworm Buddies</h1>
    <p class="welcome-text">Discover the joy of reading together!</p>
    
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
      <select v-model="selectedUser" required>
        <option disabled value="">Select a user</option> 
        <option v-for="user in users" :key="user.id" :value="user.id">{{ user.username }}</option>
      </select>
      <div>
        <span>{{ elapseMinutes }} minutes</span>
        

      <button @click="toggleTimer"  class="main-button">{{ timerRunning ? 'All Finished' : 'Time to Read!' }} </button>
      <button @click="saveSession" :disabled="!elapseMinutes">Save Session</button>
      </div>
      
    <router-link :to="{ name: 'adult-collection'}">
    <button class="secondary-button">Book Collection</button>
  </router-link>
  
    </div>
    <!-- Minute bank -->
    <button class="minute-bank-button">{{ readingMinutes }} min</button>
  </div>

</template>
<script>
import ReadingSessionService from '@/services/ReadingSessionService';

export default {
  data() {
    return {
      timerRunning: false,
      readingMinutes: 0,
      timer: null
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
      this.timerRunning = true;
      this.timer = setInterval(() => {
        this.readingMinutes++;
      }, 60000); // 1 minute interval
    },
    stopTimer() {
      this.timerRunning = false;
      clearInterval(this.timer);
    }
  }
};
</script>
<style scoped>
/* Styles for navigation */
.nav {
  position: absolute;
  top: 20px;
  left: 20px;
}


/* Main content styles */
.home {
  /* Gradient background */
  background: linear-gradient(to bottom right, #FFD166, #6A0572);
  /* Other styles */
  text-align: center;
  padding: 50px;
}
h1 {
  font-size: 36px;
  margin-bottom: 20px;
  color: #2D3142; 
}
.welcome-text {
  font-size: 24px;
  margin-bottom: 40px;
  color: #2D3142; 
}
.image-container {
  margin-bottom: 25px;
}
.library-image {
  height: 150px;
  width: 150px;
  max-width: 50%;
  border-radius: 10px;
  box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
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
/* Timer and controls styles */
.timer-controls {
  margin-top: 30px;
}
/* Minute bank button styles */
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