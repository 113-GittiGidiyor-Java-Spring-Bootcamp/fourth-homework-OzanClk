package dev.patika.fourthhomeworkapplication.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import dev.patika.fourthhomeworkapplication.model.enumeration.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student extends BaseEntity {

    private String name;
    private LocalDate birthDate;
    private String address;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToMany(mappedBy = "students",fetch = FetchType.LAZY, targetEntity = Course.class)
    @JsonManagedReference
    private List<Course> courses;



}
