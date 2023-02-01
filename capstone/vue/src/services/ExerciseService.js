import axios from "axios";
export default {
    addExercise(exercise) {
        return axios.post('/exercise/add', exercise)
    },
    getExercises() {
        return axios.get('/exercise')
    }

}