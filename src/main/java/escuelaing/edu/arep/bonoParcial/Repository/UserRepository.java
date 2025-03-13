package escuelaing.edu.arep.bonoParcial.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import escuelaing.edu.arep.bonoParcial.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    Optional<User> findByMail(String email);
    
}
