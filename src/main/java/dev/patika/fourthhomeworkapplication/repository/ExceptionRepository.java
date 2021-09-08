package dev.patika.fourthhomeworkapplication.repository;

import dev.patika.fourthhomeworkapplication.model.ApplicationErrorsResponseEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ExceptionRepository extends CrudRepository<ApplicationErrorsResponseEntity, Long> {


    @Query(value = "select * from application_errors_response_entity where created_date >= ?1 and created_date <= ?2", nativeQuery = true)
    Optional<List<ApplicationErrorsResponseEntity>> findLogByDateRange(String startDate, String endDate);

    @Query(value = "select * from application_errors_response_entity where status_code = ?1 ", nativeQuery = true)
    Optional<List<ApplicationErrorsResponseEntity>> findLogByStatusCode(int statusCode);

}
