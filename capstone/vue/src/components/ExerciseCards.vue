<template>
  <div class="exercise-cards">
    <div class="row">
      <!-- the col classes below are built in to the bootstrap grid layout. the grid has 12 columbns; 'col-md-3' refers to sections viewed on a 
        medium size display and the number 3 is how many columns each section will use. 4 columns will display when 'col-md-3'. 3 columns for 'col-sm-4 on small screens
        and 1 column for col-12 for the smallest size screen  -->
      <div
        v-for="exercise in this.$store.state.exercises"
        :key="exercise.exercise_id"
        class="col-12 col-sm-6 col-md-4 col-lg-3"
      >
        <div class="exercises shadow-sm">
          <button
            v-if="isTrainer()"
            @click="deleteExercise(exercise.exercise_id)"
            class="delete-btn btn"
          >
          <i class="bi bi-trash3"></i>
          </button>
          
          <h4 class="card-title">{{ exercise.exercise_name }}</h4>
          <p>{{ exercise.exercise_description }}</p>
          <p class="card-details">
            Suggested Weight: {{ exercise.suggested_weight }}lbs.
          </p>
          <p class="card-details">Number of Reps: {{ exercise.num_of_reps }}</p>
          <p class="card-details">Duration: {{ exercise.duration }}min.</p>
          <p class="card-details">Target Area: {{ exercise.target_area }}</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import service from "../services/ExerciseService.js";
import {isTrainer} from "../util/util.js";
export default {
  // displays the list of exercises when page is loaded
  created() {
   
    service.getExercises().then((response) => {
      if (response.status === 200) {
        this.$store.state.exercises = response.data;
      }
    });
  },

  data() {
    return {};
  },
  methods: {
    deleteExercise(id) {
      if (!window.confirm("Are you sure you would like to delete this exercise?")) return;
      service.deleteExercise(id).then((response) => {
        if(response.status !== 200) {
          return;
        }
        this.$store.commit("DELETE_EXERCISE", id)
      }).catch((err) => console.log(err));

    },
    isTrainer,
  },
};
</script>

<style scoped>

.exercise-cards {
  margin-bottom: 0px;
  margin-left: 50px;
  margin-right: 50px;
}

.exercises {
  padding: 10px;
  background: rgb(248, 249, 250);
  margin: 10px 10px 10px 10px;
  width: 100%;
  min-height: 270px;
  position: relative;
}

.exercises:hover {
  transition: all 0.2s ease-in-out;
  transform: scale(1.05);
  margin-top: 10px;
}

.delete-btn {
  position: absolute;
  top: 0px;
  right: 0px;
  border: none;
  background-color: transparent;
}

.delete-btn:hover {
  color: rgb(219, 68, 55);
}

.card-details {
  margin-bottom: 1px;
}

.card-title {
  color: rgb(219, 68, 55);
  font-style: oblique;
  font-weight: bold;
}
</style>
