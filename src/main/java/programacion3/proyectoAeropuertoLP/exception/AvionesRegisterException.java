package programacion3.proyectoAeropuertoLP.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AvionesRegisterException extends RuntimeException{
    public AvionesRegisterException(String message){
        super(message);
    }
}
