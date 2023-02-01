package com.techelevator.controller;

import com.techelevator.dao.ExerciseDao;
import com.techelevator.dao.WorkoutDao;
import com.techelevator.model.Exercise;
import com.techelevator.model.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class WorkoutController {

    @Autowired
    WorkoutDao workoutDao;

    @RequestMapping(path = "/workout", method = RequestMethod.GET)
    public List<Workout> listWorkouts() {
        return workoutDao.allWorkouts();
    }

    @RequestMapping(path = "/workout/add", method = RequestMethod.POST)
    public Workout addNewWorkout(@RequestBody Workout workout) {
        boolean result = workoutDao.createWorkout(workout);
        System.out.println(result);
        return workout;
    }

}
