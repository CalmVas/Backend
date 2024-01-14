package prometheus.KhuT.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import prometheus.KhuT.Domain.MassagePlan;
import prometheus.KhuT.Domain.User;

public interface MassagePlanRepository extends JpaRepository<MassagePlan, Long> {
}
