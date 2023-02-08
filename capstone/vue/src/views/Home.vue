<template>
  <div class="home">
   <user-column />
    
    <!-- <my-workouts/> -->
    <workout-cards/>
    <create-workout/>
  </div>
</template>

<script>
import UserColumn from "../components/UserColumn.vue";
import WorkoutCards from "../components/WorkoutCards.vue";

import CreateWorkout from '../components/CreateWorkout.vue';

export default {
  name: "Home",
  components: {
    UserColumn,
    // MyWorkouts,
    WorkoutCards,
    CreateWorkout,
  },
};
</script>

<style scoped></style>
