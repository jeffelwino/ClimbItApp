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
      { abbrev: "AL",
        name: "Alabama",
        areas: 100  
      },
      { abbrev: "AK",
        name: "Alaska",
        areas: 151
      },
      { abbrev: "AZ",
      name: "Arizona",
        areas: 200 
      },
      { abbrev: "AK",
      name: "Arkansas",
        areas: 300  
      },
       { abbrev: "CA",
       name: "California",
        areas: 400  
      },
        { abbrev: "CO",
        name: "Colorado",
        areas: 100  
      },
      { abbrev: "CN",
        name: "Connecticut",
        areas: 151
      },
      { abbrev: "DE",
        name: "Delaware",
        areas: 200 
      },
      { abbrev: "FL",
        name: "Florida",
        areas: 300  
      },
       { abbrev: "GA",
        name: "Georgia",
        areas: 400  
      },
      {
        abbrev: "OH",
        name: "Ohio",
        areas: 3
      },
      {
        abbrev: "KY",
        name: "Kentucky",
        areas: 1
      },
      {
        abbrev: "WV",
        name: "West Virginia",
        areas: 1
      },
    ],
    areas: [
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
        description: "Bullet-hard sandstone, abeautiful views, what's not to love?",
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
    ],
    crags: [
      { id: 1, area_id: 1, name: 'Mad River Gorge', description: 'The finest climbing Ohio has to offer', latitude: 39.912833, longitude: -83.860439 },
      { id: 2, area_id: 2, name: 'Muir Valley', description: 'A luxury climbing experience', latitude: 37.724503, longitude: -83.634545 },
      { id: 3, area_id: 3, name: 'Upper Meadow', description: 'Beautiful area upstream on the Meadow River', latitude: 38.151515, longitude: -80.926571 },
      { id: 4, area_id: 4, name: 'Marne Road', description: 'Roadside climbing in Newark, Ohio', latitude: 40.073522, longitude: -82.259237 },
    ],
    walls: [
      { id: 1, crag_id: 1, name: 'Amusement Wall', description: 'Fun climbing, seeps for awhile after it rains. Busy on nice days' },
      { id: 2, crag_id: 1, name: "Dad's Wall", description: "Get here early if you're looking to warm up" },
      { id: 3, crag_id: 1, name: 'Trash Shoot Area', description: 'Good variety, some spicy climbs for their grade' },
      { id: 4, crag_id: 2, name: 'Bruise Brothers', description: 'An iconic starting place for new climbers, avoid on busy days' },
      { id: 5, crag_id: 3, name: 'Zero Buttress', description: 'Watch the runouts, but some very nice vertical climbing' },
      { id: 6, crag_id: 4, name: 'Katz Wall', description: 'Good moderate climbing, and some taller walls especially for Ohio' },

    ],
    routes: [
      { id: 1, wall_id: 1, name: 'Slappy McCracken', grade: '5.10b', height: '30ft', style: 'sport' },
      { id: 2, wall_id: 1, name: 'Knope We Can', grade: '5.7', height: '25ft', style: 'sport' },
      { id: 3, wall_id: 2, name: 'Chain Mail Hula Skirt', grade: '5.7', height: '25ft', style: 'trad' },
      { id: 4, wall_id: 2, name: 'Excellent Ella', grade: '5.6', height: '25ft', style: 'sport' },
      { id: 5, wall_id: 3, name: 'Digitalis', grade: '5.11d', height: '25ft', style: 'sport' },
      { id: 6, wall_id: 3, name: 'Chin Chimney', grade: '5.8', height: '25ft', style: 'sport' },
      { id: 7, wall_id: 4, name: 'Send Me On My Way', grade: '5.9', height: '75ft', style: 'sport' },
      { id: 8, wall_id: 4, name: 'Rat Stew', grade: '5.10a', height: '75ft', style: 'sport' },
      { id: 9, wall_id: 5, name: 'Nasty Wieners', grade: '5.10a', height: '65ft', style: 'sport' },
      { id: 10, wall_id: 5, name: 'Infatuation', grade: '5.7', height: '60ft', style: 'sport' },
      { id: 11, wall_id: 6, name: 'Katz Corner', grade: '5.6', height: '35ft', style: 'sport' },
      { id: 12, wall_id: 6, name: 'Silver Streaks', grade: '5.9', height: '60ft', style: 'sport' },

    ],
    comments: [
      { id: 1, user: "Kevin", body: "This is my first comment" },
      { id: 1, user: "Michael", body: "This is a wonderful comment" },
      { id: 2, user: "Allan", body: "My Comment" },
      { id: 3, user: "Jeff", body: "Rothko is an arteest" }
    ]

  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
  },
})
