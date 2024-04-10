import { createApp } from 'vue';
import CapstoneApp from './App.vue';
import { createStore } from './store';
import router from './router';
import axios from 'axios';

// Set the base URL for server API communication with axios
axios.defaults.baseURL = import.meta.env.VITE_REMOTE_API;

// Check if there's a token stored in local storage
const currentToken = localStorage.getItem('token');
const currentUser = JSON.parse(localStorage.getItem('user'));

// If a token exists, set the authorization header for Axios
if (currentToken) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

// Create the Vuex store, passing in the stored credentials
const store = createStore(currentToken, currentUser);

// Create the Vue app, use Vuex store and Vue Router, and mount the app to the HTML element with the id 'app'
const app = createApp(CapstoneApp);
app.use(store);
app.use(router);
app.mount('#app');
