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

export default {
  data() {
    return {};
  },
  methods: {},

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
.exercise-cards {
  margin-bottom: 0px;
  margin-left: 50px;
  margin-right: 50px;
}

.exercises:hover {
  transition: all 0.2s ease-in-out;
  transform: scale(1.05);
  margin-top: 10px;
}

.card-details {
  margin-bottom: 1px;
}

.exercises {
  padding: 10px;
  background: rgb(248, 249, 250);
  margin: 10px 10px 10px 10px;
  width: 100%;
  min-height: 270px;
}

.card-title {
  color: rgb(219, 68, 55);
  font-style: oblique;
  font-weight: bold;
}
</style>
