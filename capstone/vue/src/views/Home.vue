<template>
  <div class="home">
 
    <user-column />
    <workout-cards />
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
    WorkoutCards,
    CreateWorkout,
  },
};
</script>

<style scoped></style>
