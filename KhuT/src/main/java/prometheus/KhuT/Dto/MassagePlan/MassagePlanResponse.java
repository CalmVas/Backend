package prometheus.KhuT.Dto.MassagePlan;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MassagePlanResponse {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MassagePlanCreateResponse{
        private Long massagePlan_id;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MassagePlanUpdateResponse{
        private Long massagePlan_id;
    }
}
