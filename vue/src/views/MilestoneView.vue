<template>
  <div class="milestone-view">
    <h1>Milestone Details</h1>
    <router-link :to="{ name: 'milestones' }" class="back-link">Back to Milestones</router-link>
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
    <router-link :to="{ name: 'home' }" class="home-link"> HOME </router-link>
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
        progress: 75 
      },
      readingMinutes: 0 
    };
  }
};
</script>
<style scoped>
.milestone-view {
  background-color: #F0F4F8; /* Match the background color of the HomeView page */
  max-width: 800px;
  margin: auto;
  padding: 50px;
  border-radius: 10px;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.2); /* Add light drop shadow */
  position: relative; /* Position for reading minute counter */
}
h1 {
  color: #2E4369; /* Match the heading color of the HomeView page */
  font-size: 36px;
  margin-bottom: 20px;
}
.back-link,
.home-link {
  color: #4A5568; /* Match the link color of the HomeView page */
  text-decoration: none;
  margin-bottom: 20px;
  display: block;
}
.back-link:hover,
.home-link:hover {
  text-decoration: underline;
}
.progress-container {
  margin-top: 20px;
}
.progress-bar {
  background-color: #4CAF50; /* Match the button color of the HomeView page */
  height: 20px;
  border-radius: 10px;
  overflow: hidden;
}
.progress {
  background-color: #47B881; /* Match the button hover color of the HomeView page */
  height: 100%;
}
.reading-minute-counter {
  position: absolute;
  top: 20px;
  right: 20px;
  font-size: 24px;
  color: #4A5568; /* Match the text color of the HomeView page */
}
</style>