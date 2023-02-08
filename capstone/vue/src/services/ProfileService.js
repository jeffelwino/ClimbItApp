import axios from 'axios';


export default{
    get(id) {
        return axios.get(`/profile/${id}`);
      },

      list() {
        return axios.get('/profile');
      },

      put(profile){
        return axios.put('/profile', profile);
      },

      delete(id){
          return axios.delete(`/profile/${id}`);
      },

}