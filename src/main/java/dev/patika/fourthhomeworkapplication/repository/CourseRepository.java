package dev.patika.fourthhomeworkapplication.repository;

import dev.patika.fourthhomeworkapplication.model.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN TRUE ELSE FALSE END FROM Course c WHERE c.courseCode = ?1")
    boolean findByCourseCode(String courseCode);





}
