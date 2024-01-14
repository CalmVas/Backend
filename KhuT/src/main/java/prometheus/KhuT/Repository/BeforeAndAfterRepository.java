package prometheus.KhuT.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import prometheus.KhuT.Domain.BeforeAndAfter;
import prometheus.KhuT.Domain.History;

public interface BeforeAndAfterRepository extends JpaRepository<BeforeAndAfter, Long> {
}
