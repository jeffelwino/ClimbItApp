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

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    areas: [
      {
        name: 'a1',
        area_name: 1,
        description: 'funky monkeys playing funky music',
        latitude: 39.912545,
        longitude: -83.860522
      },
      {
        name: 'a2',
        area_name: 2,
        description: 'Jazzy frogs singing the blues',
        latitude: 29.957444,
        longitude: -90.062935
      },
      {
        name: 'a3',
        area_name: 3,
        description: 'hip-hop birds hipping and hopping',
        latitude: 40.782865,
        longitude: -73.965355
      },
      {
        name: 'a4',
        area_name: 4,
        description: 'Smoky the Bear playing on his guitar',
        latitude: 35.611764,
        longitude: -83.489545
      },
      {
        name: 'a5',
        area_name: 5,
        description: 'The famous seals singing their opera',
        latitude: 41.506348,
        longitude:  -81.609336
      }
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
    }
  }
})
