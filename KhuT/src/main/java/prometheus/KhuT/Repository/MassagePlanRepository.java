package prometheus.KhuT.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import prometheus.KhuT.Domain.MassagePlan;
import prometheus.KhuT.Domain.User;

import java.util.Optional;

public interface MassagePlanRepository extends JpaRepository<MassagePlan, Long> {
    Optional<MassagePlan> findByName(String name);
}
