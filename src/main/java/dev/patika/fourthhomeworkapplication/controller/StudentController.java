package dev.patika.fourthhomeworkapplication.controller;


import dev.patika.fourthhomeworkapplication.dto.StudentDTO;
import dev.patika.fourthhomeworkapplication.model.Student;
import dev.patika.fourthhomeworkapplication.servis.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save-students")
    public ResponseEntity<Student> studentSave(@RequestBody StudentDTO studentDTO) {
        return new ResponseEntity<>(studentService.save(studentDTO).get(), HttpStatus.OK);
    }

    @GetMapping("/get-students")
    public ResponseEntity<Iterable<Student>> studentsFindAll() {
        return new ResponseEntity<>(studentService.findByAll(), HttpStatus.OK);
    }

    @GetMapping("/get-students/{id}")
    public ResponseEntity<Optional<Student>> studentFindById(@PathVariable int id) {
        return new ResponseEntity<>(studentService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/update-students")
    public ResponseEntity studentUpdate(@RequestBody StudentDTO studentDTO) {

        Optional<Student> tempStudent = studentService.findById(studentDTO.getId());

        if (tempStudent.isPresent()) {
            return new ResponseEntity<>(studentService.update(studentDTO), HttpStatus.OK);
        } else {
            return new ResponseEntity("Not Found", HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/delete-students/{id}")
    public ResponseEntity<String> studentDeleteById(@PathVariable long id) {
        studentService.deleteById(id);
        return new ResponseEntity<>("Student with id number  " + id + "has been deleted", HttpStatus.OK);
    }


}
