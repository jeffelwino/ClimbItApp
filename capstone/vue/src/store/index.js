import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'


Vue.use(Vuex)


/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if (currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    cragComment: {},
    cragComments: [],
    routeComments: [],
    routeComment: {},

    activeState: {},
    activeAreas: [],
    activeArea: {},
    activeCrags: [],
    activeCrag: {},
    activeWalls: [],
    activeWall: {},
    activeRoutes: [],
    activeRoute: {},
    key: 1,
    cloudName: "dacyocfmf",
  },
  getters: {
    nextTickId(state) {
      let tickId = 0;
      state.ticks.forEach(tick => {
        if (tick.id >= tickId) {
          tickId = tick.id;
        }
      })
      return tickId + 1;
    },
    nextCommentId(state) {
      let commentId = 0;
      state.comments.forEach(comment => {
        if (comment.commentId >= commentId) {
          commentId = comment.commentId;
        }
      })
      return commentId + 1;
    },
    nextRouteId(state) {
      let routeId = 0;
      state.routes.forEach(r => {
        if (r.id >= routeId) {
          routeId = r.id;
        }
      })
      return routeId + 1;
    },
    nextWallId(state) {
      let wallId = 0;
      state.walls.forEach(w => {
        if (w.id >= wallId) {
          wallId = w.id;
        }
      })
      return wallId + 1;
    },
    nextCragId(state) {
      let cragId = 0;
      state.crags.forEach(c => {
        if (c.id >= cragId) {
          cragId = c.id;
        }
      })
      return cragId + 1;
    },
    nextAreaId(state) {
      let areaId = 0;
      state.areas.forEach(a => {
        if (a.id >= areaId) {
          areaId = a.id;
        }
      })
      return areaId + 1;
    },

  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user', JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
    SET_ACTIVE_STATE(state, regionalState) {
      state.activeState = regionalState;
    },
    SET_ACTIVE_AREAS(state, areas) {
      state.acitveAreas = areas;
    },
    SET_ACTIVE_AREA(state, area) {
      state.activeArea = area;
    },
    SET_ACTIVE_CRAGS(state, crags) {
      state.activeCrags = crags;
    },
    SET_ACTIVE_CRAG(state, crag) {
      state.activeCrag = crag;
    },
    SET_ACTIVE_WALL(state, wall) {
      state.activeWall = wall;
    },
    SET_ACTIVE_WALLS(state, walls) {
      state.activeWalls = walls;
    },
    SET_ACTIVE_ROUTE(state, route) {
      state.activeRoute = route;
    },
    SET_ACTIVE_ROUTES(state, routes) {
      state.activeRoutes = routes;
    },


    RELOAD(state) {
      state.key += 1;
    },
    //////////////////////////////////////////////////////////////////////////////////////////////


    UPDATE_PROFILE(state, profileToChange) {
      for (let i = 0; i < state.profiles.length; i++) {
        if (state.profiles[i].id == profileToChange.id) {
          state.profiles.splice(i, 1);
          state.profiles.push(profileToChange);
          break;
        }
      }
    },
    UPDATE_PROFILE_PIC(state, info) {
      state.profiles.forEach(profile => {
        if (profile.id == info.profileId) {
          profile.pictureId = info.picture
        }
      })
    },
<<<<<<< HEAD
    UPDATE_ROUTE_IMAGE(state, info) {
      state.route.forEach(route => {
        if (route.id == info.routeId) {
          route.pictureId = info.picture
        }
      })
    },
=======
    // UPDATE_ROUTE_IMAGE(state, info){
    //   state.route.forEach(route => {
    //     if(route.id == info.routeId){
    //       route.pictureId = info.picture
    //     }
    //   })
    // },
>>>>>>> main

    SAVE_TICK(state, tick) {
      state.ticks.push(tick);
    },
    SAVE_COMMENT(state, comment) {
      state.comments.push(comment);
    },
    SAVE_ROUTE(state, newRoute) {
      state.routes.push(newRoute);
    },
    SAVE_WALL(state, newWall) {
      state.walls.push(newWall);
    },
    SAVE_CRAG(state, newCrag) {
      state.crags.push(newCrag);
    },
    SAVE_AREA(state, newArea) {
      state.areas.push(newArea);
    },
    ADD_TODO(state, info) {
      state.profiles.forEach(profile => {
        if (profile.id == info.profileId) {
          profile.todos.push(info.routeId);
        }
      })
    },

    UPDATE_ROUTE(state, route) {
      for (let i = 0; i < state.routes.length; i++) {
        if (state.routes[i].id == route.id) {
          state.routes.splice(i, 1);
          state.routes.push(route)
          break;
        }
      }
    },
    DELETE_ROUTE(state, id) {
      for (let i = 0; i < state.routes.length; i++) {
        if (state.routes[i].id == id) {
          state.routes.splice(i, 1);
          break;
        }
      }
    },
    UPDATE_WALL(state, wall) {
      for (let i = 0; i < state.walls.length; i++) {
        if (state.walls[i].id == wall.id) {
          state.walls.splice(i, 1);
          state.walls.push(wall)
          break;
        }
      }
    },
    UPDATE_CRAG(state, crag) {
      for (let i = 0; i < state.crags.length; i++) {
        if (state.crags[i].id == crag.id) {
          state.crags.splice(i, 1);
          state.crags.push(crag)
          break;
        }
      }
    },
    UPDATE_AREA(state, area) {
      for (let i = 0; i < state.areas.length; i++) {
        if (state.areas[i].id == area.id) {
          state.areas.splice(i, 1);
          state.areas.push(area)
          break;
        }
      }
    },



    // DELETES WALL
    DELETE_WALL(state, id) {
      for (let i = 0; i < state.walls.length; i++) {
        if (state.walls[i].id == id) {
          state.walls.splice(i, 1);
          break;
        }
      }
    },

  },
})
