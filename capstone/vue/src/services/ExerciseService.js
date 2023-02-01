import axios from "axios";
export default {
    addExercise(exercise){
        return axios.post('/exercise/add', exercise)
    }

}