package exceptions;

public class UsuarioYaExistenteException extends Exception {
    public UsuarioYaExistenteException(String mensaje) {
        super(mensaje);
    }
}
