package dev.patika.fourthhomeworkapplication.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import dev.patika.fourthhomeworkapplication.dto.InstructorDTO;
import dev.patika.fourthhomeworkapplication.model.Instructor;
import dev.patika.fourthhomeworkapplication.servis.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;


    @PostMapping("/saveInstructors")
    public ResponseEntity<Instructor> instructorSave(@RequestBody InstructorDTO instructorsDTO) {

        return new ResponseEntity<>(instructorService.save(instructorsDTO).get(), HttpStatus.OK);


    }


}
