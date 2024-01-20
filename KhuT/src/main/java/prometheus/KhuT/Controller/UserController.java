package prometheus.KhuT.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import prometheus.KhuT.Common.BaseResponseDto;
import prometheus.KhuT.Domain.User;
import prometheus.KhuT.Dto.User.UserRequest;
import prometheus.KhuT.Dto.User.UserResponse;
import prometheus.KhuT.Service.UserService;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @PostMapping("/api/v1/login")
    public BaseResponseDto<UserResponse.UserCreateResponse> login(@RequestBody UserRequest.UserCreateRequest userCreateRequest){
        System.out.println("userCreateRequest = " + userCreateRequest.getName());
        UserResponse.UserCreateResponse joined = userService.join(userCreateRequest);
        return BaseResponseDto.onSuccess(joined);
    }


}
