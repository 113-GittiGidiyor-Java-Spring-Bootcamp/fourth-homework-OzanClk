package dev.patika.fourthhomeworkapplication.repository;

import dev.patika.fourthhomeworkapplication.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

    @Query(value = "SELECT id,name,address,birth_date,gender,created_date,last_modified_date FROM homeworks.course_students right join student on courses_id = ?1",nativeQuery = true)
    Optional<List<Student>> studentsFindWithCourseId(Long courseId);

}
