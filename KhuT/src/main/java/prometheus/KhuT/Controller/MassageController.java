package prometheus.KhuT.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import prometheus.KhuT.Common.BaseResponseDto;
import prometheus.KhuT.Dto.Massage.MassageRequest;
import prometheus.KhuT.Dto.Massage.MassageResponse;
import prometheus.KhuT.Service.MassageService;

@RestController
@RequiredArgsConstructor
public class MassageController {
    private final MassageService massageService;

    @PostMapping("/api/v1/massage")
    public BaseResponseDto<MassageResponse.MassageCreateResponse> login(MassageRequest.MassageCreateRequest massageCreateRequest){
        MassageResponse.MassageCreateResponse massage = massageService.createMassage(massageCreateRequest);
        return BaseResponseDto.onSuccess(massage);
    }

}
