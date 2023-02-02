<template>
  <div>
    <exercise-cards/>
    <exercise-form/>
  </div>
</template>

<script>
import ExerciseCards from '../components/ExerciseCards.vue';
import ExerciseForm from '../components/ExerciseForm.vue'


export default {
  name: "Exercise",
  components: {
    ExerciseCards,
    ExerciseForm,
    
  },
   
};
</script>

<style></style>
