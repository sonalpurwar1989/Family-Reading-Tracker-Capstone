import axios from 'axios';
//const API_BASE_URL ='http://localhost:9000/';
export default {

    getUserBooks(id){
        return axios.get(`/book/user/${id}`);
    },

    getAllBooks(){
     return axios.get('/book');
    },
    searchBooksByTitle(title){
        return axios.get('/books/search', {params: {title}});
    },
    getBookById(id) {
        return axios.get(`/book/${id}`)
    },
    getBookByISBN(isbn) {
        return axios.get(`/isbn/${isbn}`)
    },
    addBook(book) {
        return axios.post('/book', book )
    },
  
    
    



}