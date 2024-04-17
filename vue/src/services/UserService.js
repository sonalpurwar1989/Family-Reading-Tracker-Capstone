import axios from 'axios';
//const API_BASE_URL ='http://localhost:9000/';
export default {

    getUsers(){
     return axios.get('/users');
    },
    getUserById(userId){
        return axios.get('/users/${isbn}');
    },
    createUser(userDto) {
        return axios.post('/users/${isbn}');
    },
    deleteUser(userId) {
        return axios.delete(`/users/${userId}`)
    },


};