package ktochto.com.example.kto.repository;

import ktochto.com.example.kto.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    //List<usr> findByLastName(String lastName);

}
