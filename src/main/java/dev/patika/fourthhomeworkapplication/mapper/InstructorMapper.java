package dev.patika.fourthhomeworkapplication.mapper;


import dev.patika.fourthhomeworkapplication.dto.InstructorDTO;
import dev.patika.fourthhomeworkapplication.model.Instructor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class InstructorMapper {

    public abstract Instructor mappingFromInstructorDTOtoInstructor(InstructorDTO instructorDTO);


}
