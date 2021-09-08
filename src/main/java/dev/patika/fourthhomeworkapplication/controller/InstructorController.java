package dev.patika.fourthhomeworkapplication.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import dev.patika.fourthhomeworkapplication.dto.InstructorDTO;
import dev.patika.fourthhomeworkapplication.model.Instructor;
import dev.patika.fourthhomeworkapplication.servis.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;


    @PostMapping("/save-instructors")
    public ResponseEntity<Instructor> instructorSave(@RequestBody InstructorDTO instructorsDTO) {
        return new ResponseEntity<>(instructorService.save(instructorsDTO).get(), HttpStatus.OK);
    }

    @GetMapping("/get-instructors")
    public ResponseEntity<Iterable<Instructor>> instructorsFindAll() {
        return new ResponseEntity<>(instructorService.findByAll(), HttpStatus.OK);
    }

    @GetMapping("/get-instructors/{id}")
    public ResponseEntity<Optional<Instructor>> instructorFindById(@PathVariable int id) {
        return new ResponseEntity<>(instructorService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/update-instructors")
    public ResponseEntity instructorUpdate(@RequestBody InstructorDTO instructorDTO) {

        Optional<Instructor> tempStudent = instructorService.findById(instructorDTO.getId());

        if (tempStudent.isPresent()) {
            return new ResponseEntity<>(instructorService.update(instructorDTO), HttpStatus.OK);
        } else {
            return new ResponseEntity("Not Found", HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/delete-instructors/{id}")
    public ResponseEntity<String> instructorDeleteById(@PathVariable int id) {

        instructorService.deleteById(id);
        return new ResponseEntity<>("Instructor with id number  " + id + " has been deleted", HttpStatus.OK);

    }

}
