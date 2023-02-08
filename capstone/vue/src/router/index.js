import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import store from '../store/index'
import Test from '../views/Test.vue'
import StatePage from '../views/StatePage.vue'
import JeffPlay from '../views/JeffPlay.vue'
import AllanPlay from '../views/AllanPlay.vue'
import KevinPlay from '../views/KevinPlay.vue'
import Area from '../views/Area.vue'
import Crag from '../views/Crag.vue'
import Wall from '../views/Wall.vue'
import Profile from '../views/Profile.vue'
import RoutePage from '../views/RoutePage.vue'
import NotFound from '../views/NotFound.vue'

Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/profile/:id",
      name: 'profile',
      component: Profile,
      meta: {
        requiresAuth: true
      }
    },

    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/state/:abbrev",
      name: "state-page",
      component: StatePage,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/area/:id",
      name: "area",
      component: Area,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/crag/:id",
      name: "crag",
      component: Crag,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: '/wall/:id',
      name: "wall",
      component: Wall,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: '/route/:id',
      name: "route-page",
      component: RoutePage,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/not-found",
      name: "NotFound",
      component: NotFound
    },
    {
      path: "/test/:id/",
      name: "test",
      component: Test,
      meta: {
        requiresAuth: true
      },
    },
    {
      path: "/jeffplay",
      name: "jeffplay",
      component: JeffPlay,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/allanplay",
      name: "allanplay",
      component: AllanPlay,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/kevinplay",
      name: "kevinplay",
      component: KevinPlay,
      meta: {
        requiresAuth: false
      }
    },
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
