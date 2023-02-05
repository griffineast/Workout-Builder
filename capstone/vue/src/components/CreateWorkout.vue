<template>
  <div class="create-workout">

    <div class="text-center">
    <button
      class="btn btn-primary show-exercises-btn shadow-sm"
      @click="toggleView"
    >
      {{this.btnText}}
    </button>
    </div>

    <!-- Display all exercises. Implement button on exercise cards 
    that will add to the workout -->
    <div class="view-exercises" v-if="expanded === true">
      <exercise-cards />
    </div>
  </div>
</template>

<script>
// import service from "../services/ExerciseService.js";
import ExerciseCards from "../components/ExerciseCards.vue";

export default {
  components: {
    ExerciseCards,
  },
  data() {
    return {
      expanded: false,
      btnText: "View Exercises",
    };
  },
  methods: {
    toggleView() {
      this.expanded = !this.expanded;

      if (this.expanded) {
        this.btnText = "Hide Exercises";
      } else {
        this.btnText = "View Exercises";
      }
    },
  },
};
</script>

<style scoped>


.show-exercises-btn {
  width: 50%;
  min-width: 300px;
  max-width: 400px;
  width: 100;
}


</style>
