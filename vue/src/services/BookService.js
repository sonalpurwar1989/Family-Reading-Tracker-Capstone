import axios from 'axios';
const API_BASE_URL ='/';
export default {

    getAllBooks(){
     return axios.get(`${API_BASE_URL}/book`);
    },
    searchBooksByTitle(title){
        return axios.get(`${API_BASE_URL}books/search`, {params: {title}});
    }

}