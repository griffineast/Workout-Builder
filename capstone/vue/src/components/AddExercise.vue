<template>
  <div class="add-exercise">
    <h1>Exercises:</h1>
    <div class="container">
      <div class="row">
        <!-- the col classes below are built in to the bootstrap grid layout. the grid has 12 columbns; 'col-md-3' refers to sections viewed on a 
        medium size display and the number 3 is how many columns each section will use. 4 columns will display when 'col-md-3'. 3 columns for 'col-sm-4 on small screens
        and 1 column for col-12 for the smallest size screen  -->
        <div v-for="exercise in this.$store.state.exercises" :key="exercise.exercise_id" class="col-12 col-sm-4 col-md-3 ">
          <div class="exercises">
            <h5>Name: {{ exercise.exercise_name }}</h5>
            <p>Description: {{ exercise.exercise_description }}</p>
            <p>Suggested Weight: {{ exercise.suggested_weight }}lbs.</p>
            <p>Number of Reps: {{ exercise.num_of_reps }}</p>
            <p>Duration: {{ exercise.duration }}min.</p>
            <p>Target Area: {{ exercise.target_area }}</p>
          </div>
        </div>
      </div>
    </div>

    <div class="exercise-form">
      <h2>Add New Exercise:</h2>
      <form @submit.prevent="newExercise">
        <div class="mb-2">
          <label class="labels">Exercise Name: </label>
          <input type="text" v-model="exercise.exercise_name" />
        </div>
        <div class="mb-2">
          <label class="labels">Exercise Description: </label>
          <input type="text" v-model="exercise.exercise_description" />
        </div>
        <div class="mb-2">
          <label class="labels">Suggested Weight: </label>
          <input type="text" v-model="exercise.suggested_weight" />
        </div>
        <div class="mb-2">
          <label class="labels">Number of Reps: </label>
          <input type="text" v-model="exercise.num_of_reps" />
        </div>
        <div class="mb-2">
          <label class="labels">Duration: </label>
          <input type="text" v-model="exercise.duration" />
        </div>
        <div class="mb-2">
          <label class="labels">Target Area: </label>
          <input type="text" v-model="exercise.target_area" />
        </div>
        <button class="btn btn-primary">Add Exercise</button>
      </form>
    </div>
  </div>
</template>

<script>
import service from "../services/ExerciseService.js";

export default {
  data() {
    return {
  
      exercise: {
        // exercise_name: "",
        // exercise_description: "",
        // suggested_weight: 0,
        // num_of_reps: 0,
        // duration: 0,
        // target_area: ""
      },
    };
  },
  methods: {
    newExercise() {
      service.addExercise(this.exercise).then((response) => {
        if (response.status === 200) {
          // using the ADD_EXERCISE mutator updates the state when adding a new exercise
          // new exercise is available to view on the page without a refresh
          this.$store.commit("ADD_EXERCISE", this.exercise);
          this.exercise = {};
          this.$router.push({ name: "Exercise" });
        }
      });
    },
  },

  // displays the list of exercises when page is opened
  created() {
    service.getExercises().then((response) => {
      if (response.status === 200) {
        this.$store.state.exercises = response.data;
      }
    });
  },
};
</script>

<style scoped>



.exercises {
  padding: 10px;
  background: rgb(238, 238, 238);
  margin: 10px;
  width: 100%;
}

.exercise-form {
  display: block;
  text-align: center;
}

form {
  margin-left: auto;
  margin-right: auto;
  text-align: center;
}

.labels {
  display: block;
  text-align: center;
  font-weight: bold;
}
</style>
