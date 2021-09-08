/**
 * This service class performs the operations for the course.
 *
 * @author ozancelik
 */

package dev.patika.fourthhomeworkapplication.servis;

import dev.patika.fourthhomeworkapplication.dto.CourseDTO;
import dev.patika.fourthhomeworkapplication.exceptions.CourseAlreadyExistsException;
import dev.patika.fourthhomeworkapplication.exceptions.StudentNumberForOneCourseExceededException;
import dev.patika.fourthhomeworkapplication.mapper.CourseMapper;
import dev.patika.fourthhomeworkapplication.model.Course;
import dev.patika.fourthhomeworkapplication.model.Student;
import dev.patika.fourthhomeworkapplication.repository.CourseRepository;
import dev.patika.fourthhomeworkapplication.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseService implements BaseService<CourseDTO> {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseMapper courseMapper;


    /**
     * This method make course registration to the database.
     *
     * @param courseDTO Object type from request
     * @return Database saved course information
     */
    @Override
    public Optional<Course> save(CourseDTO courseDTO) {
        Course course = courseMapper.mappingFromCourseDTOtoCourse(courseDTO);


        //Registration check for courses with the same code
        if (courseRepository.findByCourseCode(courseDTO.getCourseCode())) {
            throw new CourseAlreadyExistsException(courseDTO.getCourseCode() + " There are courses registered in this code");
        }

        return Optional.of(courseRepository.save(course));
    }

    @Override
    public Optional<Course> findById(long id) {
        return courseRepository.findById(id);
    }

    @Override
    public Optional<?> update(CourseDTO courseDTO) {
        Course course = courseMapper.mappingFromCourseDTOtoCourse(courseDTO);
        return Optional.of(courseRepository.save(course));
    }

    @Override
    public Iterable<Course> findByAll() {
        return courseRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        courseRepository.deleteById(id);
    }

    /**
     * This method was provide to enroll students in a course.
     *
     * @param coursesId  ID information of the registered courses in the database
     * @param studentsId ID information of the registered students in the database
     * @return Course and course registered students information
     */
    public Optional<Course> saveStudentsInTheCourse(long coursesId, long studentsId) {

        Student student = studentRepository.findById(studentsId).get();
        Course course = courseRepository.findById(coursesId).get();

        // Control of more than 20 students not being able to enroll in the course
        if (course.getStudents().size() > 20) {
            throw new StudentNumberForOneCourseExceededException("There are more than 20 students in this course");
        }

        course.addStudentsToCourse(student);

        return Optional.of(courseRepository.save(course));

    }

}
