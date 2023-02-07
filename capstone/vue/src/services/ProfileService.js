import axios from 'axios';

export default {

    loadProfiles() {
        return axios.get('/profile')
    },

    loadTicks() {
        return axios.get('/tick');
    }

}