package prometheus.KhuT.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import prometheus.KhuT.Domain.Community;
import prometheus.KhuT.Domain.History;

public interface CommunityRepository extends JpaRepository<Community, Long> {
}
