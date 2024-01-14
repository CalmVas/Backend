package prometheus.KhuT.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import prometheus.KhuT.Domain.MassageInfo;
import prometheus.KhuT.Domain.User;

public interface MassageInfoRepository extends JpaRepository<MassageInfo, Long> {
}
