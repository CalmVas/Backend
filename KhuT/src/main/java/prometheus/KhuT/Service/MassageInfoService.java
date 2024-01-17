package prometheus.KhuT.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import prometheus.KhuT.Common.status.ErrorStatus;
import prometheus.KhuT.Converter.Massage.MassageInfoConverter;
import prometheus.KhuT.Domain.Massage;
import prometheus.KhuT.Domain.MassageInfo;
import prometheus.KhuT.Domain.MassagePlan;
import prometheus.KhuT.Dto.MassageInfo.MassageInfoRequest;
import prometheus.KhuT.Dto.MassageInfo.MassageInfoResponse;
import prometheus.KhuT.Exception.handler.MassageHandler;
import prometheus.KhuT.Exception.handler.MassagePlanHandler;
import prometheus.KhuT.Repository.MassageInfoRepository;
import prometheus.KhuT.Repository.MassagePlanRepository;
import prometheus.KhuT.Repository.MassageRepository;

@Service
@RequiredArgsConstructor
public class MassageInfoService {
    private final MassageInfoRepository massageInfoRepository;
    private final MassagePlanRepository massagePlanRepository;
    private final MassageRepository massageRepository;

    public MassageInfoResponse.MassageInfoCreateResponse createMassageInfo(MassageInfoRequest.MassageInfoCreateRequest massageInfoCreateRequest){
        MassagePlan massagePlan = massagePlanRepository.findById(massageInfoCreateRequest.getMassage_plan_id()).orElseThrow(() -> new MassagePlanHandler(ErrorStatus.MASSAGE_PLAN_NOT_FOUND));
        Massage massage = massageRepository.findById(massageInfoCreateRequest.getMassage_id()).orElseThrow(() -> new MassageHandler(ErrorStatus.MASSAGE_NOT_FOUND));
        MassageInfo save = massageInfoRepository.save(MassageInfoConverter.toMassageInfoEntity(massage, massagePlan));
        return MassageInfoConverter.toMassageInfoCreateResponse(save);
    }
}
