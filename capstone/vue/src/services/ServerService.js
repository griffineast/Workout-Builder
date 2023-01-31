import axios from "axios";
export default {
    addExercise(){
        return axios.post('/addExercise')
    }

}