<template>
    <div>
        <h2>Add Reading Time</h2>
        <form @submit.prevent="submitReadingSession">
            <select v-model="selectedUser" required>
                <option disabled value="">Select a user</option>
                <option v-for="user in users" :key="user.id" :value="user.id">{{ user.username }}</option>
            </select>
            <input type="number" v-model="duration" placeholder="Duration in minutes" required />
            <button type="submit">Add <Time></Time></button>
        </form>
    </div>
</template>

<script>
import ReadingSessionService from '@/services/ReadingSessionService';

export default {
    data(){
        return{
            users: [],
            selectedUser: '',
            duration: '',
            errorMessage: ''
        };
    },
    
    methods: {
        submitReadingSession(){
            const sessionData ={
                userId: this.selectedUser,
                durationMinutes: parseInt(this.duration)
            };
            ReadingSessionService.createReadingSession(sessionData)
            .then(() => {
                alert('Time added successfully');
                this.duration = '';
            })
            .catch(error =>{
                alert('Failed to add time:' + error.message);
            })
        }
    }
}
</script>