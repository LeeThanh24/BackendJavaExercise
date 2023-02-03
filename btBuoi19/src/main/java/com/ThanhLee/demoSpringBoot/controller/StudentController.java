package com.ThanhLee.demoSpringBoot.controller;

import com.ThanhLee.demoSpringBoot.model.StudentModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    List<StudentModel> studentModelList = new ArrayList<>();

    @PutMapping("/{name1}/{age1}")
    public ResponseEntity<?> insertStudent(
            @PathVariable("name1") String myName1,
            @PathVariable("age1") int myAge1
    ) {
        studentModelList.add(new StudentModel(myName1, myAge1));
        return new ResponseEntity<>(studentModelList, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> insertStudent(@RequestBody StudentModel studentModel) {
        studentModelList .add( studentModel);
        return new ResponseEntity<>(studentModelList, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> insertStudentPost(
            @RequestParam("name1") String myName1, @RequestParam("age1") int myAge1

    ) {
        studentModelList.add(new StudentModel(myName1, myAge1));
        return new ResponseEntity<>(studentModelList, HttpStatus.OK);
    }
}
