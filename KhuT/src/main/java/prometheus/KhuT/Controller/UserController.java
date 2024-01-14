package prometheus.KhuT.Controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import prometheus.KhuT.Common.BaseResponseDto;
import prometheus.KhuT.Dto.User.UserRequest;
import prometheus.KhuT.Dto.User.UserResponse;
import prometheus.KhuT.Service.UserService;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/api/v1/signup")
    public BaseResponseDto<UserResponse.UserCreateResponse> login(UserRequest.UserCreateRequest userCreateRequest){
        UserResponse.UserCreateResponse joined = userService.join(userCreateRequest);
        return BaseResponseDto.onSuccess(joined);
    }

}
