package prometheus.KhuT.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import prometheus.KhuT.Converter.User.UserConverter;
import prometheus.KhuT.Domain.User;
import prometheus.KhuT.Dto.User.UserRequest;
import prometheus.KhuT.Dto.User.UserResponse;
import prometheus.KhuT.Repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse.UserCreateResponse join(UserRequest.UserCreateRequest userCreateRequest){
        System.out.println("userCreateRequest = " + userCreateRequest.getName());
        User user = userRepository.findByEmail(userCreateRequest.getEmail())
                .orElseGet(() -> userRepository.save(UserConverter.toUserEntity(userCreateRequest)));

        return UserConverter.toUserCreateResponse(user);
    }

}
