package com.techelevator.controller;

import com.techelevator.dao.ExerciseDao;
import com.techelevator.dao.WorkoutExerciseDao;
import com.techelevator.model.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin
@RestController
public class WorkoutController {

    @Autowired
    WorkoutExerciseDao workoutDao;

    @RequestMapping(path = "/workout", method = RequestMethod.GET)
    public ArrayList<Workout> listWorkouts() {
        return workoutDao.allWorkouts();
    }

    @RequestMapping(path = "/workout/{name}", method = RequestMethod.GET)
    public Workout getWorkoutByName(@PathVariable String name) {
        return workoutDao.getWorkoutByName(name);
    }

    @RequestMapping(path = "/workout/add/{exercise_id}", method = RequestMethod.POST)
    public boolean addExerciseToWorkout(@RequestBody Workout workout, @PathVariable int exercise_id) {
        return workoutDao.addExerciseToWorkout(workout, exercise_id);
    }

    @RequestMapping(path = "/workout/remove/{exercise_id}", method = RequestMethod.DELETE)
    public void removeExerciseFromWorkout(@RequestBody Workout workout, @PathVariable int exercise_id) {
        workoutDao.removeExerciseFromWorkout(workout, exercise_id);
    }

    @RequestMapping(path = "/workout/create/{name}", method = RequestMethod.POST)
    public void createWorkout(@PathVariable String name) {
        workoutDao.createWorkout(name);
    }

    @RequestMapping(path = "/workout/delete/{name}")
    public void deleteWorkout(@PathVariable String name) {
        workoutDao.deleteWorkout(name);
    }
}
