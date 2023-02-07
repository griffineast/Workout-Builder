<template>
  <div>
      <exercise-cards/>
      

  </div>
</template>

<script>
import service from "../services/WorkoutService.js";
import ExerciseCards from './ExerciseCards.vue'
export default {
    created() {
    const namePassed = this.$route.params.name;
    service.getWorkoutByName(namePassed).then((response) => {
      this.currentWorkout = response.data;
      this.exercises = this.currentWorkout.exercises
      
    });
  },
  data() {
      return {
          currentWorkout: {},
          exercises: []
      }

  },
  components: { ExerciseCards },

}
</script>

<style>

</style>