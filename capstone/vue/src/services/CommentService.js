import axios from 'axios';


export default{

    getCragComment(id){
        return axios.get(`/crag/comment/${id}`);
    },
    listCragComments(cragId){
        return axios.get(`/crag/${cragId}/comments`);
    },

    postCragComment(cragComment){
        return axios.post('/crag/comment', cragComment);
    },

    
    getRouteComment(id){
        return axios.get(`/route/comment/${id}`);
    },
    listRouteComments(routeId){
        return axios.get(`/route/${routeId}/comments`);
    },

    postRouteComment(routeComment){
        return axios.post('/route/comment', routeComment);
    }




}