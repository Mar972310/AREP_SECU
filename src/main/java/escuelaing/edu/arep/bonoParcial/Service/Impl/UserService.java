package escuelaing.edu.arep.bonoParcial.Service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import escuelaing.edu.arep.bonoParcial.DTO.UserDTO;
import escuelaing.edu.arep.bonoParcial.Exception.UserException;
import escuelaing.edu.arep.bonoParcial.Repository.UserRepository;
import escuelaing.edu.arep.bonoParcial.Service.UserServiceInterface;
import escuelaing.edu.arep.bonoParcial.model.User;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserService implements UserServiceInterface {

    private final UserRepository userRepository;
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) throws UserException {
        if (userRepository.findByMail(userDTO.getMail()).isPresent()) {
            throw new UserException("Email already registered");
        }
        if (userDTO.getPassword() == null || userDTO.getPassword().isEmpty()) {
            throw new UserException(UserException.PASSWORD_NULL);
        }
        String hashPassword = encoder.encode(userDTO.getPassword());
        User newUser = new User(userDTO.getName(), hashPassword, userDTO.getMail());
        userRepository.save(newUser);
        return new UserDTO(newUser.getName(), hashPassword, newUser.getMail()); 
    }

    @Override
    public boolean login(UserDTO userDTO) throws UserException {
        UserDTO userStored = getUser(userDTO);
        
        if (verify(userDTO.getPassword(), userStored.getPassword())) {
            return true;
        }
        throw new UserException(UserException.PASSWORD_INVALID);
    }

    public UserDTO getUser(UserDTO userDTO) throws UserException {
        Optional<User> user = userRepository.findByMail(userDTO.getMail());
        if (user.isEmpty()) {
            throw new UserException(UserException.USER_NOT_FOUND);
        }
        User userL = user.get();
        return new UserDTO(userL.getName(),userL.getPassword(), userL.getMail());
    }

    public boolean verify(String rawPassword, String storedPassword) throws UserException {
        if (rawPassword == null || rawPassword.isEmpty()) {
            throw new UserException(UserException.PASSWORD_NULL);
        }
        if (!encoder.matches(rawPassword, storedPassword)) {
            throw new UserException(UserException.PASSWORD_INVALID);
        }
        return true;
    }
}
