<template>
  <div></div>
</template>

<script>
import service from "../services/ExerciseService.js";
export default {
  created() {
      const idPassed = this.$route.params.id;
      service.getExerciseById(idPassed).then(
          (response) => {
              this.currentExercise = response.data;
          })
  },
  data() {
      return {
          currentExercise : {}
      }
  },
  methods: {
    deleteExercise() {
      const idPassed = this.$route.params.id;
      service.deleteExercise(idPassed).then(() => {
        this.$router.push({ name: "Trainer" });
      });
    },
  },
};
</script>

<style></style>
