package med._con.api.infra;

import jakarta.persistence.EntityNotFoundException;
import lombok.experimental.StandardException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErro404(){

        return ResponseEntity.notFound().build();

    }

}
