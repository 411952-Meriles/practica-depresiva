package ar.edu.utn.frc.tup.piii.dtos.common;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ErrorResponse {
    private String message;

    public ErrorResponse(String message)
    {
        this.message = message;
    }


}
