import axios from 'axios';


export default {
  post(todo) {
    return axios.post('/todo', todo);
  },

  listByProfile(profileId) {
    return axios.get(`/profile/${profileId}/todo`);
  },

  get(todoId) {
    return axios.get(`/todo/${todoId}`);
  },

  delete(todoId) {
    return axios.delete(`/todo/${todoId}`);
  },

}