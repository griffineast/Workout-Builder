<template>
  <div class="my-workouts">
    <div class="container text-center">
      <div class="row workouts">
        <div class="col shadow"><h1>Workout 1</h1></div>
        <div class="col shadow"><h1>Workout 2</h1></div>
        <div class="col shadow"><h1>Workout 3</h1></div>
        <div class="col shadow"><h1>Workout 4</h1></div>
      </div>

      <div class="row exercises">
        <div class="col"><h1>Build a Workout</h1></div>
      </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
.workouts .col {
  padding: 10px;
  color: white;
  background: rgb(219, 68, 55);
  margin: 10px 10px 10px 10px;
  width: 100%;
  min-height: 400px;
  position: relative;
}

.workouts .col:hover {
  transition: all 0.2s ease-in-out;
  transform: scale(1.05);
  margin-top: 10px;
}

.exercises .col {
  color: white;
  background-color: gainsboro;
  margin: 10px 10px 10px 10px;
  min-height: 100px;
}
</style>
