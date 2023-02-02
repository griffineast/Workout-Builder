import axios from "axios";
export default {
    addExercise(exercise) {
        return axios.post('/exercise/add', exercise)
    },
    getExercises() {
        return axios.get('/exercise')
    },
    getExerciseById(id) {
        return axios.get(`/exercise/${id}`)
    },
    
    deleteExercise(id) {
        return axios.delete(`/exercise/${id}`);
    }

}