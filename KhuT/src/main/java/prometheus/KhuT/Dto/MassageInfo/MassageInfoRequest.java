package prometheus.KhuT.Dto.MassageInfo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MassageInfoRequest {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MassageInfoCreateRequest{
        private Long massage_plan_id;
        private Long massage_id;
    }
}