<template>
  <div id="capstone-app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
  </div>
</template>
<style scoped>
#capstone-app {
  font-family: Arial, sans-serif;
}
#nav {
  background-color: #333;
  color: #fff;
  padding: 10px;
}
#nav a {
  color: #fff;
  text-decoration: none;
}
</style>