import Vue from 'vue'
import App from './App.vue'
import router from './router/index'
import store from './store/index'
import axios from 'axios'
import vuetify from './plugins/vuetify'
import *as VueGoogleMaps from 'vue2-google-maps'
Vue.config.productionTip = false

axios.defaults.baseURL = process.env.VUE_APP_REMOTE_API;
Vue.use(VueGoogleMaps, {
  load: {
    key: 'AIzaSyDjS1gB8xwQ6gt85wOOnQYz4c896BVXEwQ',
    libraries: 'places',

  }
})
new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app')
