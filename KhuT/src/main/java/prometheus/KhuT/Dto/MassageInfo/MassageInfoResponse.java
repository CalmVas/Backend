package prometheus.KhuT.Dto.MassageInfo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MassageInfoResponse {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MassageInfoCreateResponse{
        private Long id;
    }
}
