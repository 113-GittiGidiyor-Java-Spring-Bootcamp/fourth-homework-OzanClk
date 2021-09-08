package dev.patika.fourthhomeworkapplication.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String courseName;
    private String courseCode;
    private int courseCredit;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_id", referencedColumnName = "id", insertable = true, updatable = true, nullable = false)
    @JsonBackReference
    private Instructor instructor;


    @ManyToMany(targetEntity = Student.class)
    @JoinColumn(name = "students_id", referencedColumnName = "id")
    @JsonBackReference
    private List<Student> students;

    public Course addStudentsToCourse(Student student) {
        students.add(student);
        return this;
    }


}
