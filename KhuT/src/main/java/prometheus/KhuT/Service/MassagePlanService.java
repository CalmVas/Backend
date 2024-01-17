package prometheus.KhuT.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import prometheus.KhuT.Common.status.ErrorStatus;
import prometheus.KhuT.Converter.MassagePlan.MassagePlanConverter;
import prometheus.KhuT.Domain.MassagePlan;
import prometheus.KhuT.Domain.User;
import prometheus.KhuT.Dto.MassagePlan.MassagePlanRequest;
import prometheus.KhuT.Dto.MassagePlan.MassagePlanResponse;
import prometheus.KhuT.Exception.handler.MemberHandler;
import prometheus.KhuT.Repository.MassagePlanRepository;
import prometheus.KhuT.Repository.UserRepository;

@Service
@RequiredArgsConstructor
public class MassagePlanService {
    private final MassagePlanRepository massagePlanRepository;
    private final UserRepository userRepository;

    public MassagePlanResponse.MassagePlanCreateResponse createMassagePlan(MassagePlanRequest.MassagePlanCreateRequest massagePlanCreateRequest){

        User user = userRepository.findById(massagePlanCreateRequest.getUser_id()).orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        MassagePlan massagePlan = massagePlanRepository.findByName(massagePlanCreateRequest.getName()).orElseGet(
                () -> massagePlanRepository.save(MassagePlanConverter.toMassagePlanEntity(massagePlanCreateRequest, user))
        );

        return MassagePlanConverter.toMassagePlanCreateResponse(massagePlan);
    }
}
