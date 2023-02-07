import axios from 'axios';

export default {

    loadStates() {
        return axios.get('/state')
    },

    loadAreas() {
        return axios.get('/area');
    },

    loadCrags() {
        return axios.get('/crag');
    },

    loadWalls() {
        return axios.get('/wall');
    },

    loadRoutes() {
        return axios.get('/route');
    }

}