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
    getAreaById(id) {
        return axios.get(`area/${id}`);
    },
    saveArea(area) {
        return axios.post(`/area/create`, area)
    },


    loadCrags() {
        return axios.get('/crag');
    },
    getCragById(id) {
        return axios.get(`crag/${id}`);
    },
    getCragsByArea(id) {
        return axios.get(`/crag/area/${id}`)
    },


    loadWalls() {
        return axios.get('/wall');
    },
    getWallsByCragId(id) {
        return axios.get(`/wall/crag/${id}`);
    },
    getWallById(id) {
        return axios.get(`/wall/${id}`);
    },


    loadRoutes() {
        return axios.get('/route');
    },
    getRoutesByWall(id) {
        return axios.get(`/route/wall/${id}`);
    },
    getRouteById(id) {
        return axios.get(`route/${id}`);
    }

}