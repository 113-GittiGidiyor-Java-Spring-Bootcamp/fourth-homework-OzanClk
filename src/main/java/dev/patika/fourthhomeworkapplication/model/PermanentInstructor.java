package dev.patika.fourthhomeworkapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PermanentInstructor extends Instructor {

    @Column(name = "fixed_salary")
    private double salary;

}
