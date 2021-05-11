package ir.saeed.multi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = MyNotFoundException.class)
    public ResponseEntity<Object> handlerNotFoundException(MyNotFoundException e){
        HttpStatus notFound = HttpStatus.NOT_FOUND;
        ExceptionEntity exceptionEntity = new ExceptionEntity(e.getMessage(),
                notFound,
                LocalDateTime.now());

        return new ResponseEntity<>(exceptionEntity, notFound);
    }
}
