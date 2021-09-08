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


    @PostMapping("/save-courses")
    public ResponseEntity<Course> courseSave(@RequestBody CourseDTO courseDTO) {
        Optional<Course> course = courseService.save(courseDTO);
        if (course.isPresent()) {
            return new ResponseEntity<Course>(course.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/students-save-in-the-course/{coursesId}/{studentsId}")
    public ResponseEntity<Course> studentsSaveInTheCourse(@PathVariable Long coursesId, @PathVariable Long studentsId) {
        return new ResponseEntity<>(courseService.saveStudentsInTheCourse(coursesId, studentsId).get(), HttpStatus.OK);
    }

    @GetMapping("/get-courses")
    public ResponseEntity<Iterable<Course>> coursesFindAll() {
        return new ResponseEntity<>(courseService.findByAll(), HttpStatus.OK);
    }

    @GetMapping("/get-courses/{id}")
    public ResponseEntity<Optional<Course>> courseFindById(@PathVariable int id) {
        return new ResponseEntity<>(courseService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/update-courses")
    public ResponseEntity courseUpdate(@RequestBody CourseDTO courseDTO) {

        Optional<Course> tempStudent = courseService.findById(courseDTO.getId());

        if (tempStudent.isPresent()) {
            return new ResponseEntity<>(courseService.update(courseDTO), HttpStatus.OK);
        } else {
            return new ResponseEntity("Not Found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete-courses/{id}")
    public ResponseEntity<String> courseDeleteById(@PathVariable int id) {
        courseService.deleteById(id);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }


}
