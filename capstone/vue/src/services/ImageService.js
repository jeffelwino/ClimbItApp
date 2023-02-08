import axios from 'axios';

export default {

getPhotosByRoute(id){
    return axios.get(`/route/${id}/photos`);
},

getPhotosByProfile(id){
    return axios.get(`/profile/${id}/photos`);
},

getPhoto(id){
    return axios.get(`/photo/${id}`);
},

addPhoto(photo){
    return axios.post(`/photo/add`, photo);
},

deletePhoto(id){
    return axios.delete(`/photo/${id}`)
}

}