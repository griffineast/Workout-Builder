<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <go-to-exercise/>
     <router-link v-bind:to="{name:'Exercise'}">
          add exercise 
      </router-link>
  </div>
</template>

<script>
import GoToExercise from '../components/GoToExercise.vue';
export default {
  name: "Home",
  components: {
    GoToExercise
  }
}

</script>
