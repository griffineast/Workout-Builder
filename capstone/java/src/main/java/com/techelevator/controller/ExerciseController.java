package com.techelevator.controller;

import com.techelevator.dao.ExerciseDao;
import com.techelevator.model.Exercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ExerciseController {
    @Autowired
    ExerciseDao exerciseDao;

    @RequestMapping(path = "/exercise", method = RequestMethod.GET)
    public List<Exercise> listExercises() {
        return exerciseDao.allExercises();
    }

    @RequestMapping(path = "/exercise/add", method = RequestMethod.POST)
    public Exercise addNewExercise(@RequestBody Exercise exercise) {
        exerciseDao.createExercise(exercise);
        return exercise;
    }

}
