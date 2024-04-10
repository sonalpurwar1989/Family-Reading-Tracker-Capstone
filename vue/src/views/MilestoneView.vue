<template>
  <div class="milestone-view">
    <h1>Milestone Details</h1>
    <router-link :to="{ name: 'milestones' }">Back to Milestones</router-link>
    <div v-if="milestone">
      <p><strong>Title:</strong> {{ milestone.title }}</p>
      <p><strong>Status:</strong> {{ milestone.status }}</p>
      <div class="progress-container">
        <p><strong>Reading Minutes Tracker:</strong></p>
        <div class="progress-bar">
          <div class="progress" :style="{ width: milestone.progress + '%' }"></div>
        </div>
      </div>
    </div>
    <div v-else>
      <p>No milestone found.</p>
    </div>
    <router-link :to="{ name: 'home' }"> HOME </router-link>
    <!-- Reading minute counter -->
    <div class="reading-minute-counter">{{ readingMinutes }}</div>
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
      },
      readingMinutes: 0 // Initialize reading minutes counter
    };
  }
};
</script>
<style scoped>
body {
  background-color: #318294;
}
.milestone-view {
  max-width: 800px;
  margin: auto;
  padding: 50px;
  border-radius: 5%; 
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.2); /* Add light drop shadow */
  position: relative; /* Position for reading minute counter */
}
.progress-container {
  margin-top: 20px;
}
.progress-bar {
  background-color: #0717f0;
  height: 20px;
  border-radius: 10px;
  overflow: hidden;
}
.progress {
  background-color: #20cf37;
  height: 100%;
}
.router-link-exact-active {
  color: white; /* Change link color when active */
}
.reading-minute-counter {
  position: absolute;
  top: 20px;
  right: 20px;
  font-size: 24px;
  color: rgb(10, 8, 8);
}
</style>







