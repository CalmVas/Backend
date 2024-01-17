package prometheus.KhuT.Dto.Massage;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import prometheus.KhuT.Domain.Part;

public class MassageRequest {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MassageCreateRequest{
        private String name;
        private Part part;
        private String description;
    }
}
