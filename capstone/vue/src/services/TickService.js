import axios from 'axios';


export default{
  post(tick){
    return axios.post('/tick',tick);
  },
  
  listByRoute(routeId) {
    return axios.get(`/route/${routeId}/ticks`);
    },

    listByProfile(profileId) {
      return axios.get(`/profile/${profileId}/ticks`);
    },

      put(tick){
        return axios.put('/tick', tick);
      },

      delete(id){
          return axios.delete(`/ticks/${id}`);
      },

}