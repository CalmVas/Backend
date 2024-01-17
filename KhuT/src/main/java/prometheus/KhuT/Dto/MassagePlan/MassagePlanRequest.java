package prometheus.KhuT.Dto.MassagePlan;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import prometheus.KhuT.Domain.Part;
import prometheus.KhuT.Domain.User;

import java.time.LocalDateTime;

public class MassagePlanRequest {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MassagePlanCreateRequest{
        private Long user_id;
        private String name;
    }
}
