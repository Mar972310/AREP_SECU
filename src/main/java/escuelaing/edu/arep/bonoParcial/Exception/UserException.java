package escuelaing.edu.arep.bonoParcial.Exception;

public class UserException extends Exception{

    public static final String USER_NOT_FOUND = "The user hasn't been found";
    public static final String PASSWORD_INVALID = "la contraseña no es correcta";
    public static final String MAIL_NULL = "no se proporciono un email";
    public static final String PASSWORD_NULL = "no se proporciono una contraseña valida";

    /**
     * Constructs a new UserException with the specified message.
     *
     * @param message The detail message.
     */
    public UserException(String message) {
        super(message);
    }
    
}
