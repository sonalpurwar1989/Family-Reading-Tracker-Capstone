<template>
  <div id="capstone-app">
    <div id="nav" @click.prevent="resetBurger">
      <!-- Hamburger Menu -->
      <input type="checkbox" id="menu-toggle" class="menu-toggle" />
      <label for="menu-toggle" class="menu-icon">&#9776;</label>

      <!-- Navigation -->
      <div id="burgerList" class="menu">
        <router-link :to="{ name: 'home' }">
          <button class="home-button">Home</button>
        </router-link>

        <router-link :to="{ name: 'milestones'}">
        <button class="main-button">Milestones</button>
      </router-link>
        
        <router-link :to="{ name: 'book-search' }">
        <button class="main-button">Book Search</button>
      </router-link>

      <router-link :to="{ name: 'adult-collection'}">
    <button class="secondary-button">Book Collection</button>
  </router-link>

      <router-link :to="{ name: 'child-view' }">
        <button class="main-button">Kiddie Land</button>
      </router-link>

      <router-link :to="{ name: 'select-user'}">
        <button class="main-button">+ Family Member</button>
      </router-link>

        <router-link :to="{ name: 'meet-the-team' }">
          <button class="about-button">About</button>
        </router-link>

        <router-link :to="{ name: 'settings' }">
          <button class="settings-button">Settings</button>
        </router-link>

        <router-link :to="{ name: 'logout' }">
          <button class="logout-button">Logout</button>
        </router-link>
        
      </div>
    </div>
    <router-view />
  </div>
</template>

<script>
export default {
  methods: {
    resetBurger() {
      const toggle = document.getElementById("burgerList");

      if (toggle.style.display == "flex") {
        toggle.style.display = "none";
      } else {
        toggle.style.display = "flex";
      }
    },
  },
};
</script>

<style scoped>
#capstone-app {
  font-family: Arial, sans-serif;
}
#nav {
  background-color: #fff;
  padding: 10px;
  display: flex;
  align-items: center;
}

.menu-toggle {
  display: none;
}

.menu-icon {
  cursor: pointer;
  font-size: 20px;
}

.menu {
  display: none;
  flex-direction: column;
}

/* .menu-toggle:checked ~ .menu {
  display: flex;
  flex-direction: column;
}*/

.menu button {
  margin: 5px;
  border: none;
  background-color: transparent;
  cursor: pointer;
  font-size: 16px;
  text-decoration: underline;
  color: #333;
}
</style>



