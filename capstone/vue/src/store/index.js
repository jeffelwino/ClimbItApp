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
    // activeST: '',
    states: [
      // {
      //   abbrev: "AL",
      //   name: "Alabama",
      //   areas: 100,
      //   latitude: 32.318230,
      //   longitude: -86.902298
      // },
      // {
      //   abbrev: "AK",
      //   name: "Alaska",
      //   areas: 151,
      //   latitude: 66.160507,
      //   longitude: -153.369141
      // },
      // {
      //   abbrev: "AZ",
      //   name: "Arizona",
      //   areas: 200,
      //   latitude: 34.048927,
      //   longitude: -111.093735
      // },
      // {
      //   abbrev: "AK",
      //   name: "Arkansas",
      //   areas: 300,
      //   latitude: 34.799999,
      //   longitude: -92.199997
      // },
      // {
      //   abbrev: "CA",
      //   name: "California",
      //   areas: 400,
      //   latitude: 36.778259,
      //   longitude: -119.417931
      // },
      // {
      //   abbrev: "CO",
      //   name: "Colorado",
      //   areas: 100,
      //   latitude: 39.113014,
      //   longitude: -105.358887
      // },
      // {
      //   abbrev: "CN",
      //   name: "Connecticut",
      //   areas: 151,
      //   latitude: 41.599998,
      //   longitude: -72.699997
      // },
      // {
      //   abbrev: "DE",
      //   name: "Delaware",
      //   areas: 200,
      //   latitude: 39.000000,
      //   longitude: -75.500000
      // },
      // {
      //   abbrev: "FL",
      //   name: "Florida",
      //   areas: 300,
      //   latitude: 27.994402,
      //   longitude: -81.760254
      // },
      // {
      //   abbrev: "GA",
      //   name: "Georgia",
      //   areas: 400,
      //   latitude: 33.247875,
      //   longitude: -83.441162
      // },
      // {
      //   abbrev: "OH",
      //   name: "Ohio",
      //   areas: 3,
      //   latitude: 40.367474,
      //   longitude: -82.996216
      // },
      // {
      //   abbrev: "KY",
      //   name: "Kentucky",
      //   areas: 1,
      //   latitude: 37.839333,
      //   longitude: -84.270020
      // },
      // {
      //   abbrev: "WV",
      //   name: "West Virginia",
      //   areas: 1,
      //   latitude: 39.000000,
      //   longitude: -80.500000
      // },
    ],
    areas: [
<<<<<<< HEAD
      // {
      //   name: 'Western Ohio',
      //   stateAbbrev: 'OH',
      //   id: 1,
      //   description: 'Largely flat, but there is some stuff to do',
      //   latitude: 39.918360653356046,
      //   longitude: -84.09394703120233
      // },
      // {
      //   name: 'Red River Gorge',
      //   stateAbbrev: 'KY',
      //   id: 2,
      //   description: 'One of the largest climbing areas in the world, tons of sport climbing to do',
      //   latitude: 37.7829227300536,
      //   longitude: -83.68310316808764
      // },
      // {
      //   name: 'New River Gorge',
      //   stateAbbrev: 'WV',
      //   id: 3,
      //   description: "Bullet-hard sandstone, abeautiful views, what's not to love?",
      //   latitude: 38.070297443941975,
      //   longitude: -81.08009084642055
      // },
      // {
      //   name: 'Central/Southern Ohio',
      //   stateAbbrev: 'OH',
      //   id: 4,
      //   description: "Plenty of bouldering if that's your thing, but also some options for roped climbing",
      //   latitude: 39.90432334823612,
      //   longitude: -82.46752271817516
      // },
=======
      {
        name: 'Western Ohio',
        stateAbbrev: 'OH',
        id: 1,
        description: 'Largely flat, but there is some stuff to do',
        latitude: 39.918360653356046,
        longitude: -84.09394703120233
      },
      {
        name: 'Red River Gorge',
        stateAbbrev: 'KY',
        id: 2,
        description: 'One of the largest climbing areas in the world, tons of sport climbing to do',
        latitude: 37.7829227300536,
        longitude: -83.68310316808764
      },
      {
        name: 'New River Gorge',
        stateAbbrev: 'WV',
        id: 3,
        description: "Bullet-hard sandstone, beautiful views, what's not to love?",
        latitude: 38.070297443941975,
        longitude: -81.08009084642055
      },
      {
        name: 'Central/Southern Ohio',
        stateAbbrev: 'OH',
        id: 4,
        description: "Plenty of bouldering if that's your thing, but also some options for roped climbing",
        latitude: 39.90432334823612,
        longitude: -82.46752271817516
      },
>>>>>>> main
    ],
    crags: [
      // { id: 1, areaId: 1, name: 'Mad River Gorge', description: 'The finest climbing Ohio has to offer', position: { lat: 39.912833, lng: -83.860439 } },
      // { id: 2, areaId: 2, name: 'Muir Valley', description: 'A luxury climbing experience', position: { lat: 37.724503, lng: -83.634545 } },
      // { id: 3, areaId: 3, name: 'Upper Meadow', description: 'Beautiful area upstream on the Meadow River', position: { lat: 38.151515, lng: -80.926571 } },
      // { id: 4, areaId: 4, name: 'Marne Road', description: 'Roadside climbing in Newark, Ohio', position: { lat: 40.073522, lng: -82.259237 } },
    ],
    walls: [
      // { id: 1, cragId: 1, name: 'Amusement Wall', description: 'Fun climbing, seeps for awhile after it rains. Busy on nice days' },
      // { id: 2, cragId: 1, name: "Dad's Wall", description: "Get here early if you're looking to warm up" },
      // { id: 3, cragId: 1, name: 'Trash Shoot Area', description: 'Good variety, some spicy climbs for their grade' },
      // { id: 4, cragId: 2, name: 'Bruise Brothers', description: 'An iconic starting place for new climbers, avoid on busy days' },
      // { id: 5, cragId: 3, name: 'Zero Buttress', description: 'Watch the runouts, but some very nice vertical climbing' },
      // { id: 6, cragId: 4, name: 'Katz Wall', description: 'Good moderate climbing, and some taller walls especially for Ohio' },

    ],
    routes: [
      // { id: 1, wallId: 1, name: 'Slappy McCracken', grade: '5.10b', height: '30ft', style: 'sport', protection: "7 bolts", description: 'The oldest climbing route in Ohio. Very busy during the weekend.' },
      // { id: 2, wallId: 1, name: 'Knope We Can', grade: '5.7', height: '25ft', style: 'sport', protection: "7 bolts", description: 'Est quid nostre papadio.Lorem ipsum quod maximus manatee. \n A climb in the classic Northhampton style. \n Old granite so watch your step!.' },
      // { id: 3, wallId: 2, name: 'Chain Mail Hula Skirt', grade: '5.7', height: '25ft', style: 'trad', protection: "7 bolts", description: 'Est quid nostre papadio.The raccoons are notorious here. \n Avoid in winter.' },
      // { id: 4, wallId: 2, name: 'Excellent Ella', grade: '5.6', height: '25ft', style: 'sport', protection: "7 bolts", description: 'Est quid nostre papadio. Several portholes available. \n Avoid in Spring.' },
      // { id: 5, wallId: 3, name: 'Digitalis', grade: '5.11d', height: '25ft', style: 'sport', protection: "7 bolts", description: 'Est quid nostre papadio.' },
      // { id: 6, wallId: 3, name: 'Chin Chimney', grade: '5.8', height: '25ft', style: 'sport', protection: "7 bolts", description: 'Est quid nostre papadio.' },
      // { id: 7, wallId: 4, name: 'Send Me On My Way', grade: '5.9', height: '75ft', style: 'sport', protection: "7 bolts", description: 'Est quid nostre papadio.' },
      // { id: 8, wallId: 4, name: 'Rat Stew', grade: '5.10a', height: '75ft', style: 'sport', protection: "7 bolts", description: 'Est quid nostre papadio.' },
      // { id: 9, wallId: 5, name: 'Nasty Wieners', grade: '5.10a', height: '65ft', style: 'sport', protection: "7 bolts", description: 'Est quid nostre papadio.' },
      // { id: 10, wallId: 5, name: 'Infatuation', grade: '5.7', height: '60ft', style: 'sport', protection: "7 bolts", description: 'n/a' },
      // { id: 11, wallId: 6, name: 'Katz Corner', grade: '5.6', height: '35ft', style: 'sport', protection: "7 bolts", description: 'n/a' },
      // { id: 12, wallId: 6, name: 'Silver Streaks', grade: '5.9', height: '60ft', style: 'sport', protection: "7 bolts", description: 'n/a' },

    ],
    comments: [
      // { commentId: 1, routeId: 1, profileId: 3, body: "This is my first comment" },
      // { commentId: 2, routeId: 1, profileId: 4, body: "This is a wonderful comment" },
      // { commentId: 3, routeId: 2, profileId: 5, body: "My Comment" },
      // { commentId: 4, routeId: 3, profileId: 6, body: "Rothko is an arteest" },
      // { commentId: 5, cragId: 1, profileId: 3, body: "Whatever" },
      // { commentId: 6, cragId: 1, profileId: 4, body: "Hey you" },
      // { commentId: 7, cradId: 2, profileId: 5, body: "Wonderful" }
    ],
    // cragComments: [
    //   { commentId: 1, cragId: 1, user: "Kevin", body: "This is my crag" },
    //   { commentId: 2, cragId: 1, user: "Michael", body: "This is a wonderful crag" },
    //   { commentId: 3, cragId: 2, user: "Allan", body: "My crag" },
    //   { commentId: 4, cragId: 3, user: "Jeff", body: "Rothko is a crag" },
    //   { commentId: 5, cragId: 1, user: "I don't care", body: "Whatever crag" },
    //   { commentId: 6, cragId: 1, user: "Timmy", body: "Hey you crag" },
    //   { commentId: 7, cradId: 2, user: "Lola", body: "Wonderful crag" }
    // ],
    ticks: [
      // {
      //   id: 1,
      //   profileId: 4,
      //   routeId: 9,
      //   date: "10/18/2022",
      //   note: "Great climb, loved the moves on the arete. Redpoint after giving it a burn on toprope earlier in the week",
      //   rating: 4,
      // },
      // {
      //   id: 2,
      //   profileId: 4,
      //   routeId: 6,
      //   date: "6/11/2021",
      //   note: "Stout for the grade, but very fun. Onsight ascent, sketchy move to the anchors though.",
      //   rating: 3,
      // },
      // {
      //   id: 3,
      //   profileId: 3,
      //   routeId: 9,
      //   date: "10/19/2022",
      //   note: "Great.",
      //   rating: 3,
      // },
      // {
      //   id: 4,
      //   profileId: 2,
      //   routeId: 9,
      //   date: "10/20/2022",
      //   note: "Not reptar",
      //   rating: 1,
      // },
      // {
      //   id: 5,
      //   profileId: 4,
      //   routeId: 1,
      //   date: "10/18/2022",
      //   note: "Great climb, loved the moves on the arete. Redpoint after giving it a burn on toprope earlier in the week",
      //   rating: 4,
      // },
    ],
    profiles: [
      // {
      //   id: 2,
      //   name: "Admin",
      //   location: "Admin",
      //   bio: "Admin",
      //   todos: [],
      //   picture: {
      //     cloudName: "dacyocfmf",
      //     publicId: "ssu0yraojylulspeeuhv"

      //   }
      // }, {
      //   id: 1,
      //   name: "user",
      //   location: "user",
      //   bio: "user",
      //   todos: [],
      //   picture: {
      //     cloudName: "dacyocfmf",
      //     publicId: "cld-sample-5"
      //   }
      // },
      // {
      //   id: 3,
      //   name: "Kevin",
      //   location: "Long Island, New  York",
      //   bio: "My name is Kevin and I like to climb rocks",
      //   todos: [1, 9, 5],
      //   picture: {
      //     cloudName: "dacyocfmf",
      //     publicId: "s"
      //   }
      // },
      // {
      //   id: 5,
      //   name: "Mike",
      //   location: "Sunbury, Ohio",
      //   bio: "My name is Michael and I like to climb rocks",
      //   todos: [12, 5, 3],
      //   picture: {
      //     cloudName: "dacyocfmf",
      //     publicId: "cld-sample-4"
      //   }
      // },
      // {
      //   id: 4,
      //   name: "Jeff",
      //   location: "Chicago, Illinois",
      //   bio: "I am Jeff Winograd and I love front-end developpment, design, and vuetify",
      //   todos: [12],
      //   picture: {
      //     cloudName: "dacyocfmf",
      //     publicId: "cld-sample-3"
      //   }
      // },
      // {
      //   id: 6,
      //   name: "Allan",
      //   bio: "Hey there, my name is Allan, and I climb trees not rocks so I think this site is frankly rather dumb",
      //   todos: [],
      //   picture: {
      //     cloudName: "dacyocfmf",
      //     publicId: "cld-sample-2"
      //   }
      // },
    ]

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
    LOAD_PROFILES(state, profiles) {
      profiles.forEach(profile => {
        if (!state.profiles.find(profile)) {
          state.profiles.push(profile);
        }
      })
    },
    LOAD_TICKS(state, ticks) {
      ticks.forEach(tick => {
        if (!state.ticks.includes(tick)) {
          state.ticks.push(tick);
        }
      })
    },
    LOAD_STATES(state, states) {
      states.forEach(s => {
        if (!state.states.includes(s)) {
          state.states.push(s);
        }
      })
    },
    LOAD_AREAS(state, areas) {
      areas.forEach(area => {
        if (!state.areas.includes(area)) {
          state.areas.push(area);
        }
      })
    },
    LOAD_CRAGS(state, crags) {
      crags.forEach(crag => {
        if (!state.crags.includes(crag)) {
          state.crags.push(crag);
        }
      })
    },
    LOAD_WALLS(state, walls) {
      walls.forEach(wall => {
        if (!state.walls.includes(wall)) {
          state.walls.push(wall);
        }
      })
    },

    LOAD_ROUTES(state, routes) {
      routes.forEach(route => {
        if (!state.routes.includes(route)) {
          state.routes.push(route);
        }
      })
    },
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
