package escuelaing.edu.arep.bonoParcial.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class UserDTO {
    private String name;
    private String password;
    private String mail;
}
