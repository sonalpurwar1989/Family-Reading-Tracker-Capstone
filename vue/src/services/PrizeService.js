import axios from 'axios';
//const API_BASE_URL ='http://localhost:9000/';
export default {

    getAllPrizes(){
     return axios.get('/prizes');
    },

    createPrize(prize) {
        return axios.post(`/prizes`, prize);
    },
    updatePrize(prizeId,prize) {
        return axios.put(`/prizes/${prizeId}`, prize);
    },
    deletePrize(prizeId) {
        return axios.delete(`/prizes/${prizeId}` );
    },
  
    
    



}