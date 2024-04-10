<template>
    <div class="milestone-view">
      <h1>Milestone Details</h1>
      <router-link :to="{ name: 'milestones' }">Back to Milestones</router-link>
      <div v-if="milestone">
        <p><strong>Title:</strong> {{ milestone.title }}</p>
        
        <p><strong>Status:</strong> {{ milestone.status }}</p>
      
        <div class="progress-container">
          <p><strong>Progress:</strong></p>
          <div class="progress-bar">
            <div class="progress" :style="{ width: milestone.progress + '%' }"></div>
          </div>
        </div>
      </div>
      <div v-else>
        <p>No milestone found.</p>
      </div>
      <router-link :to="{ name: 'milestones' }">Back to Milestones</router-link>
    </div>
  </template>
  <script>
  export default {
    data() {
      return {
        milestone: {
          title: "MILESTONES",
          status: "In Progress",
          progress: 60 // Assuming the progress is in percentage
        }
      };
    }
  };
  </script>
  <style scoped>
  .milestone-view {
    max-width: 800px;
    margin: auto;
    padding: 20px;
  }
  .progress-container {
    margin-top: 20px;
  }
  .progress-bar {
    background-color: #F0F0F0;
    height: 20px;
    border-radius: 10px;
    overflow: hidden;
  }
  .progress {
    background-color: #4CAF50;
    height: 100%;
  }
  </style>