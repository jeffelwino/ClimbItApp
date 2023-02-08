import axios from 'axios';

export default {

    loadStates() {
        return axios.get('/state')
    },
    getStateByAbbrev(abbrev) {
        return axios.get(`/state/${abbrev}`);
    },
    loadAreas() {
        return axios.get('/area');
    },
    getAreasByState(abbrev) {
        return axios.get(`area/state/${abbrev}`)
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