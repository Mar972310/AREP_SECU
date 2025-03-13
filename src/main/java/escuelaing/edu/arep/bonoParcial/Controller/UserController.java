package escuelaing.edu.arep.bonoParcial.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import escuelaing.edu.arep.bonoParcial.DTO.UserDTO;
import escuelaing.edu.arep.bonoParcial.Exception.UserException;
import escuelaing.edu.arep.bonoParcial.Service.UserServiceInterface;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserServiceInterface userService;

    @Autowired
    public UserController(UserServiceInterface userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) {
        try {
            UserDTO createdUser = userService.createUser(userDTO);
            return ResponseEntity.ok(createdUser);
        } catch (UserException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO userDTO) {
        try {
            boolean authenticatedUser = userService.login(userDTO);
            return ResponseEntity.ok(authenticatedUser);
        } catch (UserException e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }
}
