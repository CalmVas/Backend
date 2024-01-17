package prometheus.KhuT.Converter.Massage;

import prometheus.KhuT.Domain.Massage;
import prometheus.KhuT.Dto.Massage.MassageRequest;
import prometheus.KhuT.Dto.Massage.MassageResponse;

public class MassageConverter {
    public static MassageResponse.MassageCreateResponse toMassageCreateResponse(Massage massage){
        return MassageResponse.MassageCreateResponse.builder()
                .id(massage.getId())
                .name(massage.getName())
                .build();
    }

    public static Massage toMassageEntity(MassageRequest.MassageCreateRequest massageCreateRequest){
        return Massage.builder()
                .name(massageCreateRequest.getName())
                .part(massageCreateRequest.getPart())
                .description(massageCreateRequest.getDescription())
                .build();
    }
}
