/**
 * This class performs logging of error catching operations to the database.
 *
 * @author ozancelik
 */

package dev.patika.fourthhomeworkapplication.servis;

import dev.patika.fourthhomeworkapplication.model.ApplicationErrorsResponseEntity;
import dev.patika.fourthhomeworkapplication.repository.ExceptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExceptionService implements BaseService<ApplicationErrorsResponseEntity> {

    @Autowired
    private ExceptionRepository exceptionRepository;

    //Get recorded logs according to date range
    public Optional<List<ApplicationErrorsResponseEntity>> findLogByDateRange(String startDate, String endDate) {
        return exceptionRepository.findLogByDateRange(startDate, endDate);
    }

    //Get recorded logs according to Error Type (Status Code)
    public Optional<List<ApplicationErrorsResponseEntity>> findLogByErrorType(int errorType) {
        return exceptionRepository.findLogByStatusCode(errorType);
    }

    @Override
    public Optional<ApplicationErrorsResponseEntity> save(ApplicationErrorsResponseEntity applicationErrorsResponse) {
        return Optional.of(exceptionRepository.save(applicationErrorsResponse));
    }

    @Override
    public Optional<?> findById(long id) {
        return Optional.empty();
    }

    @Override
    public Optional<?> update(ApplicationErrorsResponseEntity applicationErrorsResponse) {
        return Optional.empty();
    }

    @Override
    public Iterable<?> findByAll() {
        return exceptionRepository.findAll();
    }

    @Override
    public void deleteById(int id) {

    }


}
