<template>
  <div class="add-exercise">
    <h1>Add New Exercise!</h1>

    <form @submit.prevent="addNewExercise">
      <div>
        <label>Exercise Name: </label>
        <input type="text" v-model="exercise.exercise_name" />
      </div>
      <div>
        <label>Exercise Description: </label>
        <input type="text" v-model="exercise.exercise_description" />
      </div>
      <div>
        <label>Suggested Weight: </label>
        <input type="text" v-model="exercise.suggested_weight" />
      </div>
      <div>
        <label>Number Of Reps: </label>
        <input type="text" v-model="exercise.num_of_reps" />
      </div>
      <div>
        <label>Duration: </label>
        <input type="text" v-model="exercise.duration" />
      </div>
      <div>
        <label>Target Area: </label>
        <input type="text" v-model="exercise.target_area" />
      </div>
      <button>Add Exercise</button>
    </form>
  </div>
</template>

<script>
import service from "../services/ExerciseService.js";
export default {
  data() {
    return {
      exercise: {
        exercise_name: "",
        exercise_description: "",
        suggested_weight: 0,
        num_of_reps: 0,
        duration: 0,
        target_area: ""
      },
    };
  },
  methods: {
    addNewExercise() {
      service.addExercise(this.exercise).then((response) => {
        if (response.status === 200) {
          this.$store.commit("ADD_EXERCISE", this.exercise);
         this.exercise = {};
          this.$router.push({ name: "home" });
        }
       
      });
    },
  },
};
</script>

<style></style>
