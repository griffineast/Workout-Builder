import axios from "axios";
export default {
  

  // not final, need to implement on backend
  getWorkoutByName(name) {
    return axios.get(`/workout/${name}`)
  },


  getWorkoutExercises(name) {
    return axios.get(`/workout/${name}`);
  },

  getWorkouts() {
    return axios.get(`/workout`);
  },

  addWorkout(workout) {
    return axios.post(`/workout/add`, workout);
  },

  updateWorkout(workout, id) {
    return axios.put(`/workout/edit/${id}`, workout);
  },

  deleteWorkout(id) {
    return axios.delete(`/workout/delete/${id}`);
  },
  
};
