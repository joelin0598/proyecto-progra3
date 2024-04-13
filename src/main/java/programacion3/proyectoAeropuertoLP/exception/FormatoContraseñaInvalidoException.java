package programacion3.proyectoAeropuertoLP.exception;

public class FormatoContraseñaInvalidoException extends RuntimeException {

    public FormatoContraseñaInvalidoException() {
        super();
    }

    public FormatoContraseñaInvalidoException(String message) {
        super(message);
    }

    public FormatoContraseñaInvalidoException(String message, Throwable cause) {
        super(message, cause);
    }

    public FormatoContraseñaInvalidoException(Throwable cause) {
        super(cause);
    }
}