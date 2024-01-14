package prometheus.KhuT.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import prometheus.KhuT.Domain.Massage;
import prometheus.KhuT.Domain.User;

public interface MassageRepository extends JpaRepository<Massage, Long> {
}
