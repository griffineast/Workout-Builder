<template>
<div class="container">
<div class="row justify-content-between">
        <div class="mx-auto" style="width: 250px;">
        <h1>My Trainer</h1>
        <tr><button class="btn btn-primary mt-md"> Suggested Workouts</button> </tr>
      <tr><button class="btn btn-primary mt-2"> Trainer Chat</button> </tr>
          </div>
    <div class="col-6">
    <div class="text-center">
    <h1>What would you like to hit today?</h1>
            <button class="btn btn-primary mx-2">Legs</button>
            <button class="btn btn-primary mx-2">Shoulders</button>
            <button class="btn btn-primary mx-2"> Arms</button>
            <button class="btn btn-primary mx-2">Chest</button>
            <button class="btn btn-primary mx-2">Cardio</button>
            <button class="btn btn-primary mx-2">Abs</button>
            <button class="btn btn-primary mx-5">I'm Feeling Lucky!</button>
            </div> 
            </div>
    <div class="mx-auto" style="width: 220px;">
    <h2> My Account </h2>
 <tr> <button class="btn btn-primary mt-2"> My Workouts</button></tr>
 <tr> <button class="btn btn-primary mt-2"> Workout History</button></tr>
 <tr> <button class="btn btn-primary mt-2"> Exercise Suggestions Form</button></tr>
 <tr> <button class="btn btn-primary mt-2"> Exercise Suggestions Status</button></tr>
 <tr> <button class="btn btn-primary mt-2"> Blocked Workouts</button></tr> 
</div>
    </div>
    </div>
</template>

<script>
export default {
    data() {
        return{

        }
    }

}
</script>

<style scoped>
.col-6{
    font-size: 3rem;
}
.h1{
    font-size: 70px;
}
.container{
    font-weight: 0px;
    background-color: azure;
    border-block: 10rem;
    margin: 10rem 6rem;
}
.body{
    background-color: cornflowerblue;
}
</style>
