<template>
  <div class="home">
    <display-exercises />
    <user-column />

    <workout-cards />
  </div>
</template>

<script>
import UserColumn from "../components/UserColumn.vue";
import WorkoutCards from "../components/WorkoutCards.vue";
import DisplayExercises from "../components/DisplayExercises.vue";

export default {
  name: "Home",
  components: {
    UserColumn,
    WorkoutCards,
    DisplayExercises,
  },
};
</script>

<style scoped></style>
