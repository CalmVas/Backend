package prometheus.KhuT.Converter.Massage;

import prometheus.KhuT.Domain.Massage;
import prometheus.KhuT.Domain.MassageInfo;
import prometheus.KhuT.Domain.MassagePlan;
import prometheus.KhuT.Dto.MassageInfo.MassageInfoResponse;

public class MassageInfoConverter {
    public static MassageInfoResponse.MassageInfoCreateResponse toMassageInfoCreateResponse(MassageInfo massageInfo){
        return MassageInfoResponse.MassageInfoCreateResponse.builder()
                .id(massageInfo.getId())
                .build();
    }

    public static MassageInfo toMassageInfoEntity(Massage massage, MassagePlan massagePlan){
        return MassageInfo.builder()
                .massage(massage)
                .massagePlan(massagePlan)
                .build();
    }
}
