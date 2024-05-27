package programacion3.proyectoAeropuertoLP.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AvionesActiveException extends RuntimeException{
    public AvionesActiveException(String message){
        super(message);
    }
}
