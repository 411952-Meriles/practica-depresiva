package ar.edu.utn.frc.tup.piii.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Getter
public class BusinessError extends ResponseStatusException {
    private final HttpStatus status;

    public BusinessError(HttpStatus status, String message) {
        super(status, message);
        this.status = status;
    }
    public HttpStatus getStatus() {
        return status;
    }
}
