/**
 * This service class performs the operations for the instructor.
 * @author ozancelik
 */

package dev.patika.fourthhomeworkapplication.servis;


import com.fasterxml.jackson.databind.ObjectMapper;
import dev.patika.fourthhomeworkapplication.dto.InstructorDTO;
import dev.patika.fourthhomeworkapplication.exceptions.InstructorIsAlreadyExistException;
import dev.patika.fourthhomeworkapplication.mapper.InstructorMapper;
import dev.patika.fourthhomeworkapplication.model.Instructor;
import dev.patika.fourthhomeworkapplication.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class InstructorService implements BaseService<InstructorDTO> {

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private InstructorMapper instructorMapper;

    public Instructor findByIdForMapper(Long id) {

        return instructorRepository.findById(id).orElse(null);
    }


    @Override
    public Optional<Instructor> save(InstructorDTO instructorDTO) {

        if (instructorRepository.findInstructorsWithTheSamePhoneNumber(instructorDTO.getPhoneNumber())) {
            throw new InstructorIsAlreadyExistException("Found more than 1 Instructor with this number");
        }

        // Serializing the InstructorDTO object for save processing
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> props = mapper.convertValue(instructorDTO, Map.class);
        Instructor instructor = mapper.convertValue(props, Instructor.class);

        return Optional.of(instructorRepository.save(instructor));
    }

    @Override
    public Optional<Instructor> findById(long id) {
        return Optional.of(instructorRepository.findById(id).orElse(null));
    }

    @Override
    public Optional<?> update(InstructorDTO object) {
        return Optional.empty();
    }

    @Override
    public Iterable<?> findByAll() {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }
}
