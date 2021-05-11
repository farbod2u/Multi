package ir.saeed.multi;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ExceptionEntity {
    private final String message;
    private final HttpStatus httpStatus;
    private final LocalDateTime dateTime;
}
