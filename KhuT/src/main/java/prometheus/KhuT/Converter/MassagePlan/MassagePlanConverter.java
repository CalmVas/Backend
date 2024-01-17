package prometheus.KhuT.Converter.MassagePlan;

import prometheus.KhuT.Domain.Massage;
import prometheus.KhuT.Domain.MassagePlan;
import prometheus.KhuT.Domain.User;
import prometheus.KhuT.Dto.Massage.MassageRequest;
import prometheus.KhuT.Dto.Massage.MassageResponse;
import prometheus.KhuT.Dto.MassagePlan.MassagePlanRequest;
import prometheus.KhuT.Dto.MassagePlan.MassagePlanResponse;

import java.time.LocalDateTime;

public class MassagePlanConverter {
    public static MassagePlanResponse.MassagePlanCreateResponse toMassagePlanCreateResponse(MassagePlan massagePlan){
        return MassagePlanResponse.MassagePlanCreateResponse.builder()
                .massagePlan_id(massagePlan.getId())
                .build();
    }

    public static MassagePlan toMassagePlanEntity(MassagePlanRequest.MassagePlanCreateRequest massagePlanCreateRequest, User user){
        return MassagePlan.builder()
                .name(massagePlanCreateRequest.getName())
                .likes(0)
                .createdAt(LocalDateTime.now())
                .user(user)
                .build();
    }
}
