package prometheus.KhuT.Dto.Massage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import prometheus.KhuT.Domain.Part;

public class MassageResponse {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MassageCreateResponse{
        private Long id;
        private String name;
    }
}
