import { createRouter, createWebHistory } from 'vue-router';
import { useStore } from 'vuex';
// Import components
import HomeView from '../views/HomeView.vue';
import LoginView from '../views/LoginView.vue';
import LogoutView from '../views/LogoutView.vue';
import RegisterView from '../views/RegisterView.vue';
import MilestoneView from '../views/MilestoneView.vue'; // Import MilestoneView component
<<<<<<< HEAD
import PrizeView from '../components/PrizeView.vue';
=======
import BookView from '../views/BookView.vue'; // Import Book Search page
>>>>>>> 9914492f42f6bbab536aeb3635306f114123db4c
const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/login',
    name: 'login',
    component: LoginView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: '/logout',
    name: 'logout',
    component: LogoutView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: '/register',
    name: 'register',
    component: RegisterView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: '/milestones', // Route for MilestoneView
    name: 'milestones',
    component: MilestoneView,
    meta: {
      requiresAuth: true // Requires authentication
    }
  },
  {
<<<<<<< HEAD
    path: '/prizes',
    name: 'prizes',
    component: PrizeView,
    meta: {
      requiresAuth: true
    }
  }
=======
    path: '/books',
    name: 'book-search',
    component: BookView,
  },
>>>>>>> 9914492f42f6bbab536aeb3635306f114123db4c
];
const router = createRouter({
  history: createWebHistory(),
  routes
});
// Navigation guard
router.beforeEach((to, from, next) => {
  const isAuthenticated = localStorage.getItem('token');
  const store = useStore();
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);
  if (requiresAuth && !isAuthenticated) {
    next('/login');
  } else {
    next();
  }
});
export default router;