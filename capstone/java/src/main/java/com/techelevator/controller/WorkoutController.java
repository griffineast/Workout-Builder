package com.techelevator.controller;

import com.techelevator.dao.ExerciseDao;
import com.techelevator.dao.WorkoutExerciseDao;
import com.techelevator.model.Exercise;
import com.techelevator.model.Workout;
import com.techelevator.model.WorkoutExercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class WorkoutController {

    @Autowired
    WorkoutExerciseDao workoutDao;
    @Autowired
    ExerciseDao exerciseDao;

    @RequestMapping(path = "/workout", method = RequestMethod.GET)
    public ArrayList<Workout> listWorkouts() {
        return workoutDao.allWorkouts();
    }

    @RequestMapping(path = "/workout/{name}", method = RequestMethod.GET)
    public Workout getWorkoutByName(@PathVariable String workoutName) {
        return workoutDao.getWorkoutByName(workoutName);
    }

    @RequestMapping(path = "/workout/add/{exercise_id}", method = RequestMethod.POST)
    public boolean addExerciseToWorkout(@RequestBody Workout workout, @PathVariable int exercise_id) {
        return workoutDao.addExerciseToWorkout(workout, exercise_id);
    }



    @RequestMapping(path = "/workout/edit/{id}", method = RequestMethod.PUT)
    public WorkoutExercise updateWorkoutExercise(@RequestBody WorkoutExercise workout, @PathVariable int id) {
        WorkoutExercise updatedWorkout = workoutDao.updateWorkoutExercise(workout, id);
        if (updatedWorkout == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No such id: " + id);
        }
        else {
            return updatedWorkout;
        }
    }

    //@RequestMapping(path = "/workout/delete/{id}", method = RequestMethod.DELETE)
    //public void deleteWorkoutExercise(@PathVariable int id) {
        //WorkoutExercise workoutToDelete = workoutDao.getWorkoutExerciseById(id);
        //if (workoutToDelete == null) {
            //throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No such id: " + id);
        //}
        //else {
            //workoutDao.deleteWorkoutExercise(id);
        //}
    //}

    //@RequestMapping(path = "/workout/{name}", method = RequestMethod.GET)
    //public ArrayList<String> getWorkoutExercises(@PathVariable String name) {
        //ArrayList<Integer> exercises = workoutDao.getWorkoutExercises(name);
        //ArrayList<String> exercisesNames = new ArrayList<>();
        //for (int i = 0; i < exercises.size(); i++) {
            //Exercise exercise = exerciseDao.getExerciseById(exercises.get(i));
            //exercisesNames.add(exercise.getExercise_name());
        //}
        //return exercisesNames;
    //}
}
