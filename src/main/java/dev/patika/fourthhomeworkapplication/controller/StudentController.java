package dev.patika.fourthhomeworkapplication.controller;


import dev.patika.fourthhomeworkapplication.dto.StudentDTO;
import dev.patika.fourthhomeworkapplication.model.Student;
import dev.patika.fourthhomeworkapplication.servis.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/saveStudents")
    public ResponseEntity<Student> saveStudent(@RequestBody StudentDTO studentDTO) {

        return new ResponseEntity<>(studentService.save(studentDTO).get(), HttpStatus.OK);

    }


}
