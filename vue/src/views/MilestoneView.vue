<template>
  <div class="milestone-view">
    <h1>Reading Tracker</h1>
    <div v-if="milestone">
      <div class="progress-container">
        <div class="progress-bar">
          <div class="progress" :style="{ width: progressBarWidth + '%' }"></div>
        </div>
      </div>
      <div class="reading-minute-counter">{{ readingMinutes }} min</div>
      <!-- <button @click="startTimer" :disabled="timerRunning" class="main-button">{{ timerRunning ? 'Timer Running' : 'Start Reading' }}</button>
      <button @click="stopTimer" :disabled="!timerRunning" class="secondary-button">Stop Reading</button> -->
      <input type="number" v-model="manualTime" placeholder="Enter minutes manually" class="manual-time-input">
      <!-- <input type="date" v-model="manualDate" placeholder="Select date" class="manual-date-input"> -->
      <button @click="addManualTime" class="main-button">Add Manual Time</button>
    </div>
    <div v-else>
      <p>No milestone found.</p>
    </div>
  </div>
</template>

<script>
import ReadingSessionService from '@/services/ReadingSessionService.js';

export default {
  data() {
    return {
      milestone: {
        progress: 0,
        sessions:[],
        selectedUser: '',
        duration: ''
      },
      readingMinutes: 0,
      timer: null,
      timerRunning: false,
      manualTime: 0,
      manualDate: ''
    };
  },
  computed: {
    progressBarWidth() {
      return this.milestone.progress;
    }
  },
  methods: {
    startTimer() {
      if (!this.timerRunning) {
        this.timer = setInterval(() => {
          this.readingMinutes++;
          this.milestone.progress++;
          if (this.milestone.progress % 5 === 0) {
            this.showPopUp();
          }
        }, 60000); // 1 minute interval
        this.timerRunning = true;
      }
    },
    stopTimer() {
      clearInterval(this.timer);
      this.timer = null;
      this.timerRunning = false;
    },
    addManualTime() {
      if (!this.manualTime || isNaN(parseInt(this.manualTime))) {
        alert('Please enter a valid number');
        return;
      }
      
      const minutesToAdd = parseInt(this.manualTime);
      
      this.readingMinutes += minutesToAdd;
      
      this.saveSession(minutesToAdd);
      
      alert(`${minutesToAdd} minutes added successfully.`);
      this.manualTime = 0; 
    },
    showPopUp() {
      alert("Congratulations for adding to your minute bank!");
    },
    saveSession(minutesToAdd) {
      //
      ReadingSessionService.recordReadingSession({
        userId: this.selectedUser,
        durationMinutes: minutesToAdd
      }).then(() => {
        console.log("Reading session saved successfully");
      }).catch(error => {
        console.error('Error saving reading session:', error);
      });
    }
  }
}
</script>

<style scoped>
h1 {
  color: #eee5e4;
  font-size: 36px;
  font-weight: bold;
  margin-bottom: 20px;
}
.milestone-view {
  /* Gradient background */
  background: linear-gradient(to bottom right, #FFD166, #6A0572);
  text-align: center;
  padding: 80px;
  font-family: 'Arial', sans-serif;
  max-width: 800px;
  margin: auto;
  border-radius: 10px;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);
}
.progress-container {
  margin-top: 20px;
}
.progress-bar {
  background-color: #47B881;
  height: 20px;
  border-radius: 10px;
  overflow: hidden;
}
.progress {
  background-color: #FFD166;
  height: 100%;
}
.reading-minute-counter {
  position: absolute;
  top: 20px;
  right: 20px;
  font-size: 24px;
  color: #4A5568;
}
.main-button {
  margin: 10px;
  padding: 12px 30px;
  font-size: 18px;
  background-color: #FFD166;
  color: #2D3142;
  border-radius: 8px;
  cursor: pointer;
  transition: background-color 0.3s ease;
  box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
}
.main-button:hover {
  background-color: #FF9F51;
}
.secondary-button {
  margin: 50px;
  padding: 10px 20px;
  font-size: 16px;
  background-color: #6A0572;
  color: white;
  border: none;
  border-radius: 6px;
  cursor: pointer;
  transition: background-color 0.3s ease;
  box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
}
.secondary-button:hover {
  background-color: #FF4E00;
}
.manual-time-input {
  margin: 10px;
  padding: 10px;
  font-size: 16px;
  border: 2px solid #47B881;
  border-radius: 8px;
  outline: none;
} 
.manual-time-input::placeholder,
.manual-date-input::placeholder {
  color: #A0AEC0;
}
</style>
