import axios from "axios";



export default {

    fetchAllReadingSession(){
     return axios.get('/reading-sessions');
    },
    fetchReadingSessionById(sessionId){
        return axios.get(`/reading-sessions/${sessionId }`);
    },
    recordReadingSession(sessionData) {
        return axios.post('/reading-sessions', sessionData)
    },
    updateReadingSession(sessionId, sessionData) {
        return axios.put(`/reading-sessions/${sessionId}`, sessionData);
    },
   deleteReadingSession(sessionId) {
        return axios.delete(`/reading-sessions/${sessionId}`)
   },
}

