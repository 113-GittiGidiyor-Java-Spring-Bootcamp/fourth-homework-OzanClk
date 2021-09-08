/**
 * This service class performs the operations for the student.
 *
 * @author ozancelik
 */


package dev.patika.fourthhomeworkapplication.servis;


import dev.patika.fourthhomeworkapplication.dto.StudentDTO;
import dev.patika.fourthhomeworkapplication.exceptions.StudentAgeNotValidException;
import dev.patika.fourthhomeworkapplication.mapper.StudentMapper;
import dev.patika.fourthhomeworkapplication.model.Student;
import dev.patika.fourthhomeworkapplication.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements BaseService<StudentDTO> {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;

    public List<Student> studentsFindWithCourseId(Long courseId) {

        return studentRepository.studentsFindWithCourseId(courseId).orElse(null);
    }

    /**
     * This method performs student registration to the database.
     * @param studentDTO student data access object from request
     * @return Information about the student registered in the database
     */
    @Override
    public Optional<Student> save(StudentDTO studentDTO) {

        //Age calculation operation and age check corresponding to birthdate value given by studentDTO object
        Period intervalPeriod = Period.between(studentDTO.getBirthDate(), LocalDate.now());

        if (intervalPeriod.getYears() < 18 || intervalPeriod.getYears() > 40) {
            throw new StudentAgeNotValidException("Student Age Not Valid");
        }

        Student student = studentMapper.mappingFromStudentDTOtoStudent(studentDTO);

        return Optional.of(studentRepository.save(student));

    }

    @Override
    public Optional<Student> findById(long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student;
    }

    @Override
    public Optional<Student> update(StudentDTO studentDTO) {
        Student student = studentMapper.mappingFromStudentDTOtoStudent(studentDTO);
        return Optional.of(studentRepository.save(student));
    }

    @Override
    public Iterable<Student> findByAll() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        studentRepository.deleteById(id);
    }


}
