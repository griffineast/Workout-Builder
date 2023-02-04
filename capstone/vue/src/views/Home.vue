<template>
  <div class="home">
    
    <my-workouts />
    
    
   
    
  </div>
</template>

<script>
import MyWorkouts from '../components/MyWorkouts.vue';


export default {
  name: "Home",
  components: {
    MyWorkouts,
   
    
  },
};


</script>

<style scoped>

.home {
  text-align: center;
}

a {
  text-decoration: none;
}

</style>
