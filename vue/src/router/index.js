import { createRouter, createWebHistory } from 'vue-router';
import { useStore } from 'vuex';
// Import components
import HomeView from '../views/HomeView.vue';
import LoginView from '../views/LoginView.vue';
import LogoutView from '../views/LogoutView.vue';
import RegisterView from '../views/RegisterView.vue';
import MilestoneView from '../views/MilestoneView.vue'; // Import MilestoneView component
import PrizeView from '../components/PrizeView.vue'; // Import Prize View Page
import BookView from '../views/BookView.vue'; // Import Book Search page
import SelectUser from '../views/SelectUser.vue'; // Import Select User page
import ChildView from '../views/ChildView.vue'; // Import Child View page
import SettingsView from '../views/SettingsView.vue'; // Import Settings page
import AdultCollection from '../views/AdultCollectionView.vue'; // Import Adult Library page
import ChildCollections from '../views/ChildCollection.vue'; // Import child Library
import MeetTheTeam from '../views/MeetTheTeamView.vue'; // Import Meet the Team and About page
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
    path: '/milestones',
    name: 'milestones',
    component: MilestoneView,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/prizes',
    name: 'prizes',
    component: PrizeView,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/books/search',
    name: 'book-search',
    component: BookView
  },
  {
    path: '/select-user',
    name: 'select-user',
    component: SelectUser
  },
  {
    path: '/child-view',
    name: 'child-view',
    component: ChildView
  },
  {
    path: '/settings',
    name: 'settings',
    component: SettingsView
  },
  {
    path: '/meet-the-team',
    name: 'meet-the-team',
    component: MeetTheTeam
  },
  {
    path: '/adult-collection',
    name: 'adult-collection',
    component: AdultCollection
  },
  {
    path: '/child-collection',
    name: 'child-collection',
    component: ChildCollections
  }
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