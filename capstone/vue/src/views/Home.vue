<template>
  <div class="home">
   <display-exercises/>
   <user-column/>
    
    <!-- <my-workouts/> -->
    <workout-cards/>
    <create-workout/>

    
    
   
    
  </div>
</template>

<script>
import UserColumn from '../components/UserColumn.vue';
import CreateWorkout from '../components/CreateWorkout.vue';
// import MyWorkouts from '../components/MyWorkouts.vue';
import WorkoutCards from '../components/WorkoutCards.vue';


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

<style scoped>



</style>
