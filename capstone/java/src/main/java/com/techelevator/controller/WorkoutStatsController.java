package com.techelevator.controller;

import com.techelevator.dao.WorkoutStatsDao;
import com.techelevator.model.WorkoutStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class WorkoutStatsController {

    @Autowired
    WorkoutStatsDao workoutStatsDao;

    @RequestMapping(path = "/workoutStats", method = RequestMethod.GET)
    public List<WorkoutStats> listWorkouts() {
        return workoutStatsDao.allWorkoutStats();
    }

    @RequestMapping(path = "/workoutStats/add", method = RequestMethod.POST)
    public WorkoutStats addNewWorkout(@RequestBody WorkoutStats workoutStat) {
        boolean result = workoutStatsDao.createWorkoutStat(workoutStat);
        return workoutStat;
    }

}
