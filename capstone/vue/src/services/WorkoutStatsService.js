import axios from "axios";
export default {
  getWorkoutStats() {
    return axios.get("/workoutStats");
  },

  addWorkoutStats(workoutStat) {
    return axios.post("/workoutStats/add", workoutStat);
  },
};
