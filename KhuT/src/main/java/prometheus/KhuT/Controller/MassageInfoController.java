package prometheus.KhuT.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import prometheus.KhuT.Common.BaseResponseDto;
import prometheus.KhuT.Dto.MassageInfo.MassageInfoRequest;
import prometheus.KhuT.Dto.MassageInfo.MassageInfoResponse;
import prometheus.KhuT.Service.MassageInfoService;

@RestController
@RequiredArgsConstructor
public class MassageInfoController {
    private final MassageInfoService massageInfoService;

    @PostMapping("/api/v1/massageinfo")
    public BaseResponseDto<MassageInfoResponse.MassageInfoCreateResponse> createMassageInfo(MassageInfoRequest.MassageInfoCreateRequest massageInfoCreateRequest){
        MassageInfoResponse.MassageInfoCreateResponse massageInfo = massageInfoService.createMassageInfo(massageInfoCreateRequest);
        return BaseResponseDto.onSuccess(massageInfo);
    }
}
