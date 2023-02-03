<template>
  <div class="home">
    <h1>Welcome!</h1>
    <my-workouts />
    
   
    
  </div>
</template>

<script>
import MyWorkouts from '../components/MyWorkouts.vue';

export default {
  name: "Home",
  components: {
    MyWorkouts
    
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
