<template>
  <div class="home">
   <!-- <user-column /> -->
    <trainer-hero />
    <!-- <my-workouts/> -->
    <workout-cards/>
    <create-workout/>
  </div>
</template>

<script>
// import UserColumn from "../components/UserColumn.vue";
import WorkoutCards from "../components/WorkoutCards.vue";

import CreateWorkout from '../components/CreateWorkout.vue';
import TrainerHero from '../components/TrainerHero.vue';

export default {
  name: "Home",
  components: {
    // UserColumn,
    // MyWorkouts,
    WorkoutCards,
    CreateWorkout,
    TrainerHero,
  },
};
</script>

<style scoped></style>
