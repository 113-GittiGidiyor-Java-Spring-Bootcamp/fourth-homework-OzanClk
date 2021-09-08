package dev.patika.fourthhomeworkapplication.controller;

import dev.patika.fourthhomeworkapplication.dto.CourseDTO;
import dev.patika.fourthhomeworkapplication.model.Course;
import dev.patika.fourthhomeworkapplication.servis.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CourseController {


    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


    @PostMapping("/saveCourses")
    public ResponseEntity<Course> saveCourse(@RequestBody CourseDTO courseDTO) {
        Optional<Course> course = courseService.save(courseDTO);
        if (course.isPresent()) {
            return new ResponseEntity<Course>(course.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/studentsSaveInTheCourse/{coursesId}/{studentsId}")
    public ResponseEntity<Course> studentsSaveInTheCourse(@PathVariable Long coursesId, @PathVariable Long studentsId) {

        return new ResponseEntity<>(courseService.saveStudentsInTheCourse(coursesId, studentsId).get(), HttpStatus.OK);

    }


}
