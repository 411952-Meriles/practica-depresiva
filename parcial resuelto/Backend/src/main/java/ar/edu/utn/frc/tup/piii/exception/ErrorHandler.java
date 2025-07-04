package ar.edu.utn.frc.tup.piii.exception;

import ar.edu.utn.frc.tup.piii.dtos.common.ErrorApi;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(BusinessError.class)
    public ResponseEntity<ErrorApi> handleBusinessError(BusinessError businessError) {
        return ResponseEntity.status(businessError.getStatus()).body(
            new ErrorApi(
                LocalDateTime.now().toString(),
                businessError.getStatus().value(),
                "",
                businessError.getMessage()
            )
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorApi> handleGlobalException(Exception exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
            new ErrorApi(
                LocalDateTime.now().toString(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "",
                "Internal Server Error"
            )
        );
    }
}
