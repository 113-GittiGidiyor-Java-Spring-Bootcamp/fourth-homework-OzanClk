package dev.patika.fourthhomeworkapplication.exceptions;

import dev.patika.fourthhomeworkapplication.model.ApplicationErrorsResponseEntity;
import dev.patika.fourthhomeworkapplication.servis.ExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private ExceptionService exceptionService;

    @ExceptionHandler({InstructorIsAlreadyExistException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApplicationErrorsResponseEntity> handleException(InstructorIsAlreadyExistException exception) {

        ApplicationErrorsResponseEntity appErrorResponse = new ApplicationErrorsResponseEntity();

        appErrorResponse.setMessage(exception.getMessage());
        appErrorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());

        exceptionService.save(appErrorResponse);

        return new ResponseEntity<>(appErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({CourseAlreadyExistsException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApplicationErrorsResponseEntity> handleException(CourseAlreadyExistsException exception) {

        ApplicationErrorsResponseEntity appErrorResponse = new ApplicationErrorsResponseEntity();

        appErrorResponse.setMessage(exception.getMessage());
        appErrorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());

        exceptionService.save(appErrorResponse);

        return new ResponseEntity<>(appErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({StudentAgeNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApplicationErrorsResponseEntity> handleException(StudentAgeNotValidException exception) {

        ApplicationErrorsResponseEntity appErrorResponse = new ApplicationErrorsResponseEntity();

        appErrorResponse.setMessage(exception.getMessage());
        appErrorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());

        exceptionService.save(appErrorResponse);

        return new ResponseEntity<>(appErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({StudentNumberForOneCourseExceededException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApplicationErrorsResponseEntity> handleException(StudentNumberForOneCourseExceededException exception) {

        ApplicationErrorsResponseEntity appErrorResponse = new ApplicationErrorsResponseEntity();

        appErrorResponse.setMessage(exception.getMessage());
        appErrorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());

        exceptionService.save(appErrorResponse);

        return new ResponseEntity<>(appErrorResponse, HttpStatus.BAD_REQUEST);
    }


}
