package escuelaing.edu.arep.bonoParcial.Service;

import escuelaing.edu.arep.bonoParcial.DTO.UserDTO;
import escuelaing.edu.arep.bonoParcial.Exception.UserException;

public interface UserServiceInterface {
    
    UserDTO createUser(UserDTO user) throws UserException;
    boolean login(UserDTO user) throws UserException;
    
}
