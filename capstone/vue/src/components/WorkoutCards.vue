<template>
  <div class="workout-cards">
    <div class="row">
      <!-- Creates a card for each workout in the DB -->
      <div
        v-for="workout in this.workouts"
        :key="workout.workout_id"
        class="col-12 col-sm-6 col-md-4 col-lg-3"
      >
        <!-- Card Container -->
        <div class="workouts shadow-sm">
          <!-- Card Details -->
          <h4 class="card-title">{{ workout.name }}</h4>

          <!-- TODO: loop through exercsises for the workout -->
          <div 
          v-for="exercise in this.workout"
          :key="exercise"
          class="workout-exercises"
          >
            <p>Exercise: {{ workout.exercise }}</p>
          </div>


          <div class="card-btns">
            <!-- TODO: Create addToWorkout method  -->
            <!-- Add new exercise to workout button -->
            <button
              @click="addExerciseToWorkout(workout.workout_id)"
              class="btn btn-primary add-btn"
            >
              <i class="bi bi-plus-square"></i>
            </button>

            <!-- TODO: Create updateWorkout method -->
            <!-- Edit button -->
            <button
              @click="updateWorkout(workout.workout_id)"
              class="btn btn-primary edit-btn"
            >
              <i class="bi bi-pencil"></i>
            </button>

            <!-- TODO: Create deleteWorkout method -->
            <!-- Delete button -->
            <button
              @click="deleteWorkout(workout.workout_id)"
              class="delete-btn btn"
            >
              <i class="bi bi-trash3"></i>
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import service from "../services/WorkoutService.js";
import { isTrainer } from "../util/util.js";
export default {
  // displays the list of workouts when page is loaded
  created() {

    service.getWorkouts().then((response) => {
      if (response.status === 200) {
        this.$store.state.workouts = response.data;
        this.workouts = response.data;
      }

    });

    // const name = this.$route.params.name;
    // service.getWorkoutExercises(name).then((response) => {
    //   if (response.status === 200) {
    //     this.$store.state.workouts = response.data;
    //     this.workouts = response.data;
    //   }

    // });
  },

  data() {
    return {
      workout: {},
      workoutName: '',
      workouts: [],
    };
  },
  methods: {
    isTrainer,

    
  },
};
</script>

<style scoped>
.workout-cards {
  margin-bottom: 0px;
  margin-left: 50px;
  margin-right: 50px;
}

.workouts {
  padding: 10px;
  background: rgb(248, 249, 250);
  margin: 10px 10px 10px 10px;
  width: 100%;
  min-height: 270px;
  position: relative;
}

.workouts:hover {
  transition: all 0.2s ease-in-out;
  transform: scale(1.05);
  margin-top: 10px;
}

.card-btns {
  display: flex;
  flex-direction: column;
  position: absolute;
  right: 0;
  bottom: 0;
  margin-right: 5px;
  margin-bottom: 5px;
}

.add-btn {
  color: black;
  padding: 0px;
  border: none;
  background-color: transparent;
}

.add-btn:hover {
  color: rgb(219, 68, 55);
}

.add-btn:active {
  background-color: transparent;
}

.edit-btn {
  color: black;
  padding: 0px;
  border: none;
  background-color: transparent;
}

.edit-btn:hover {
  color: rgb(219, 68, 55);
}

.edit-btn:active {
  background-color: transparent;
}

.delete-btn {
  padding: 0px;
  border: none;
  background-color: transparent;
}

.delete-btn:hover {
  color: rgb(219, 68, 55);
}

.delete-btn:active {
  background-color: transparent;
}

.card-details p {
  margin-top: 0px;
  margin-bottom: 0px;
}

.card-title {
  color: rgb(219, 68, 55);
  font-style: oblique;
  font-weight: bold;
}
</style>
