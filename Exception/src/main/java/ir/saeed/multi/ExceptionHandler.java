package ir.saeed.multi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {
            MyNotFoundException.class,
            MyNotNullParameter.class,
            MyLenghException.class
    })
    public ResponseEntity<Object> handlerNotFoundException(RuntimeException e) {
        HttpStatus notFound = HttpStatus.NOT_FOUND;
        if (e.getClass() == MyNotNullParameter.class)
            notFound = HttpStatus.NOT_ACCEPTABLE;
        if (e.getClass() == MyLenghException.class)
            notFound = HttpStatus.LENGTH_REQUIRED;

        return new ResponseEntity<>(
                new ExceptionEntity(
                        e.getMessage(),
                        notFound,
                        LocalDateTime.now()
                ),
                notFound);
    }
}
