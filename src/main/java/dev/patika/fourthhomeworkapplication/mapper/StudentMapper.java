package dev.patika.fourthhomeworkapplication.mapper;


import dev.patika.fourthhomeworkapplication.dto.StudentDTO;
import dev.patika.fourthhomeworkapplication.model.Student;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public abstract class StudentMapper {

    public abstract Student mappingFromStudentDTOtoStudent(StudentDTO studentDTO);

}
