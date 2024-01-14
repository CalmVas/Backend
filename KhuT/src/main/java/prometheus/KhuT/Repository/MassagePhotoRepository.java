package prometheus.KhuT.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import prometheus.KhuT.Domain.Massage;
import prometheus.KhuT.Domain.MassagePhoto;

public interface MassagePhotoRepository extends JpaRepository<MassagePhoto, Long> {
}
