<template>
  <div>
      <trainer-hero />
      <exercise-cards />
      <exercise-form />

  </div>
</template>

<script>
import ExerciseCards from '../components/ExerciseCards.vue'
import ExerciseForm from '../components/ExerciseForm.vue'
import TrainerHero from '../components/TrainerHero.vue'
export default {
  components: { TrainerHero, ExerciseForm, ExerciseCards },
    name: "Trainer"

}
</script>

<style>

</style>