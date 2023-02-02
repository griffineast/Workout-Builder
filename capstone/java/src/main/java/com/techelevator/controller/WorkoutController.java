package com.techelevator.controller;

import com.techelevator.dao.WorkoutDao;
import com.techelevator.model.Exercise;
import com.techelevator.model.Workout;
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
    WorkoutDao workoutDao;

    @RequestMapping(path = "/workout/exercises/{name}", method = RequestMethod.GET)
    public ArrayList<Integer> getWorkoutExercises(@PathVariable String name) {
        return workoutDao.getCompleteWorkout(name);
    }

    @RequestMapping(path = "/workout", method = RequestMethod.GET)
    public List<Workout> listWorkouts() {
        return workoutDao.allWorkouts();
    }

    @RequestMapping(path = "/workout/add", method = RequestMethod.POST)
    public Workout addNewWorkout(@RequestBody Workout workout) {
        boolean result = workoutDao.createWorkout(workout);
        return workout;
    }

    @RequestMapping(path = "/workout/{id}", method = RequestMethod.PUT)
    public Workout updateWorkout(@RequestBody Workout workout, @PathVariable int id) {
        Workout updatedWorkout = workoutDao.updateWorkout(workout, id);
        if (updatedWorkout == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No such id: " + id);
        }
        else {
            return updatedWorkout;
        }
    }

    @RequestMapping(path = "/workout/{id}", method = RequestMethod.DELETE)
    public void deleteWorkout(@PathVariable int id) {
        Workout workoutToDelete = workoutDao.getWorkoutById(id);
        if (workoutToDelete == null) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No such id: " + id);
        }
        else {
            workoutDao.deleteWorkout(id);
        }
    }
}
