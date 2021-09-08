package dev.patika.fourthhomeworkapplication.mapper;


import dev.patika.fourthhomeworkapplication.dto.CourseDTO;
import dev.patika.fourthhomeworkapplication.model.Course;
import dev.patika.fourthhomeworkapplication.servis.CourseService;
import dev.patika.fourthhomeworkapplication.servis.InstructorService;
import dev.patika.fourthhomeworkapplication.servis.StudentService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class CourseMapper {


    @Autowired
    public CourseService courseService;

    @Autowired
    public InstructorService instructorService;

    @Autowired
    public StudentService studentService;


    @Mapping(target = "instructor", expression = "java(instructorService.findByIdForMapper(courseDTO.getInstructorId()))")
    //@Mapping(target = "students", expression = "java(studentService.studentsFindWithCourseId(courseDTO.getStudentsCourseId()))")
    public abstract Course mappingFromCourseDTOtoCourse(CourseDTO courseDTO);


}
