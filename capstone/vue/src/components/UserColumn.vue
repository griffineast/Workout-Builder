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
<<<<<<< HEAD
            <button class="btn btn-primary mx-2">Legs</button>
            <button class="btn btn-primary mx-2">Shoulders</button>
            <button class="btn btn-primary mx-2">Arms</button>
            <button class="btn btn-primary mx-2">Chest</button>
            <button class="btn btn-primary mx-2">Cardio</button>
            <button class="btn btn-primary mx-2">Abs</button>
            <button class="btn btn-primary mx-5">I'm Feeling Lucky!</button>
=======
        <div class="target-btns">
            <button class="btn btn-primary mx-2" v-for= "(btn, index) in buttons" v-bind:key="btn" @click="toggleActiveClass(index)" :class= "{active: btn.active}">
                {{btn.name}}
            </button>
        </div>
            <button class="btn btn-primary mx-5" :class="{active:isActive}" @click="isActive = !isActive">I'm Feeling Lucky!</button>
>>>>>>> main
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
<<<<<<< HEAD
=======
            isActive: false,
            buttons: [{name: 'Legs', active: false}, 
            {name: 'Shoulders', active: false}, 
            {name: 'Biceps', active: false}, 
            {name: 'Triceps', active: false}, 
            {name: 'Chest', active: false}, 
            {name: 'Back', active: false}, 
            {name: 'Cardio', active: false}, 
            {name: 'Abs', active: false}]
        };
    },
    methods: {
       toggleActiveClass: function(index){
     this.buttons[index].active=!this.buttons[index].active;
        },
        toggleImFeelingLucky: function(event) {
            event.isActive = !event.enable;
            this.buttons.forEach(function(button) {
                button.active = false;
            })
>>>>>>> main
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
<<<<<<< HEAD

=======
.body{
    background-color: cornflowerblue;
}

.active {
    background-color:cyan;
}
>>>>>>> main
</style>
