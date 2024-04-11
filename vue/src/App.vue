<template>
  <div id="capstone-app">
    <div id="nav">
      <button class="menu-btn" @click="toggleMenu">
        <span class="hamburger"></span>
      </button>
      <div class="menu-items" :class="{ 'show-menu': showMenu }">
        <router-link v-bind:to="{ name: 'home' }">Home</router-link>
        <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      </div>
    </div>
    <router-view />
  </div>
</template>
<script>
export default {
  data() {
    return {
      showMenu: false
    };
  },
  methods: {
    toggleMenu() {
      this.showMenu = !this.showMenu;
    }
  }
};
</script>
<style scoped>
#capstone-app {
  font-family: Arial, sans-serif;
}
#nav {
  background-color: #333;
  color: #fff;
  padding: 10px;
  display: flex;
  align-items: center;
}
.menu-btn {
  background: transparent;
  border: none;
  cursor: pointer;
  padding: 5px;
}
.hamburger {
  display: block;
  width: 20px;
  height: 2px;
  background-color: #fff;
  margin-bottom: 5px;
}
.menu-items {
  display: none;
}
.show-menu .menu-items {
  display: block;
}
.menu-items a {
  color: #fff;
  text-decoration: none;
  display: block;
  margin-bottom: 5px;
}
</style>