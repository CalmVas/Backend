package prometheus.KhuT.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import prometheus.KhuT.Domain.History;
import prometheus.KhuT.Domain.User;

public interface HistoryRepository extends JpaRepository<History, Long> {
}
