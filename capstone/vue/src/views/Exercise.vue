<template>
  <div>
    <exercise-cards/>
    <create-exercise/>
  </div>
</template>

<script>
import ExerciseCards from '../components/ExerciseCards.vue';
import CreateExercise from '../components/CreateExercise.vue'


export default {
  name: "Exercise",
  components: {
    ExerciseCards,
    CreateExercise,
    
  },
   
};
</script>

<style></style>
