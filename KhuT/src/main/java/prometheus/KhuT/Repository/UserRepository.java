package prometheus.KhuT.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import prometheus.KhuT.Domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
