package prometheus.KhuT.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import prometheus.KhuT.Converter.Massage.MassageConverter;
import prometheus.KhuT.Domain.Massage;
import prometheus.KhuT.Dto.Massage.MassageRequest;
import prometheus.KhuT.Dto.Massage.MassageResponse;
import prometheus.KhuT.Repository.MassageRepository;

@Service
@RequiredArgsConstructor
public class MassageService {

    private final MassageRepository massageRepository;

    public MassageResponse.MassageCreateResponse createMassage(MassageRequest.MassageCreateRequest massageCreateRequest){
        Massage massage = massageRepository.save(MassageConverter.toMassageEntity(massageCreateRequest));
        return MassageConverter.toMassageCreateResponse(massage);
    }
}
