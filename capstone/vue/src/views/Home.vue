<template>
  <div class="home">
    <!-- <display-exercises /> -->
    <user-column />
    <workout-cards />
    <create-workout/>
  </div>
</template>

<script>
import UserColumn from "../components/UserColumn.vue";
import WorkoutCards from "../components/WorkoutCards.vue";
// import DisplayExercises from "../components/DisplayExercises.vue";
import CreateWorkout from '../components/CreateWorkout.vue';

export default {
  name: "Home",
  components: {
    UserColumn,
    WorkoutCards,
    // DisplayExercises,
    CreateWorkout,
  },
};
</script>

<style scoped></style>
