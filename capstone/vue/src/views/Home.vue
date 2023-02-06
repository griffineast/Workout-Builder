<template>
  <div class="home">
    
    <!-- <my-workouts/> -->
    <workout-cards/>
    <create-workout/>

    
    
   
    
  </div>
</template>

<script>
import CreateWorkout from '../components/CreateWorkout.vue';
// import MyWorkouts from '../components/MyWorkouts.vue';
import WorkoutCards from '../components/WorkoutCards.vue';


export default {
  name: "Home",
  components: {
    // MyWorkouts,
    WorkoutCards,
    CreateWorkout,
   
    
  },
};


</script>

<style scoped>



</style>
