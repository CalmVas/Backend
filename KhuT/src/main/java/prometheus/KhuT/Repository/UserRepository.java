package prometheus.KhuT.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import prometheus.KhuT.Domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findOneWithRolesByUsername(String username);

    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);
}
