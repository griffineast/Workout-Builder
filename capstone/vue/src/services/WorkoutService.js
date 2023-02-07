import axios from "axios";
export default {
  

  getWorkouts() {
    return axios.get(`/workout`);
  },

  addExerciseToWorkout(workout, exercise_id) {
    return axios.post(`/workout/add/${exercise_id}`, workout)
  },

  getWorkoutExercises(name) {
    return axios.get(`/workout/${name}`);
  },

  // not final, need to implement on backend
  getWorkoutByName(name) {
    return axios.get(`/workout/${name}`)
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
