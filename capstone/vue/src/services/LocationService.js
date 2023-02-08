import axios from 'axios';

export default {
    // State methods
    loadStates() {
        return axios.get('/state')
    },
    getStateByAbbrev(abbrev) {
        return axios.get(`/state/${abbrev}`);
    },

    // Area
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
    updateArea(area) {
        return axios.put(`/area`, area);
    },

    // Crag
    loadCrags() {
        return axios.get('/crag');
    },
    getCragById(id) {
        return axios.get(`crag/${id}`);
    },
    getCragsByArea(id) {
        return axios.get(`/crag/area/${id}`)
    },
    saveCrag(crag) {
        return axios.post('/crag/create', crag)
    },
    updateCrag(crag) {
        return axios.put('/crag', crag)
    },

    // Wall
    loadWalls() {
        return axios.get('/wall');
    },
    getWallsByCragId(id) {
        return axios.get(`/wall/crag/${id}`);
    },
    getWallById(id) {
        return axios.get(`/wall/${id}`);
    },
    saveWall(wall) {
        return axios.post('/wall/create', wall)
    },

    // Route
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