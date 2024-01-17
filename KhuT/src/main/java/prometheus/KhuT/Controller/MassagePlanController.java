package prometheus.KhuT.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import prometheus.KhuT.Common.BaseResponseDto;
import prometheus.KhuT.Dto.MassagePlan.MassagePlanRequest;
import prometheus.KhuT.Dto.MassagePlan.MassagePlanResponse;
import prometheus.KhuT.Service.MassagePlanService;

@RestController
@RequiredArgsConstructor
public class MassagePlanController {
    private final MassagePlanService massagePlanService;

    @PostMapping("/api/v1/massageplan")
    public BaseResponseDto<MassagePlanResponse.MassagePlanCreateResponse> createMassagePlan(MassagePlanRequest.MassagePlanCreateRequest massagePlanCreateRequest){
        MassagePlanResponse.MassagePlanCreateResponse massagePlan = massagePlanService.createMassagePlan(massagePlanCreateRequest);
        return BaseResponseDto.onSuccess(massagePlan);
    }

}
