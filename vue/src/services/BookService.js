import axios from 'axios';
const API_BASE_URL ='http://localhost:9000/';
export default {

    getAllBooks(){
     return axios.get(`${API_BASE_URL}/book`);
    },
    searchBooksByTitle(title){
        return axios.get(`${API_BASE_URL}books/search`, {params: {title}});
    },
    getBookById(id) {
        return axios.get(`${API_BASE_URL}/book/${id}`)
    },
    getBookByISBN(isbn) {
        return axios.get(`${API_BASE_URL}isbn/${isbn}`)
    }

    

}