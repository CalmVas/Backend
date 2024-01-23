package prometheus.KhuT.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prometheus.KhuT.Common.BaseResponseDto;
import prometheus.KhuT.Domain.User;
import prometheus.KhuT.Dto.User.UserDto;
import prometheus.KhuT.Dto.User.UserRequest;
import prometheus.KhuT.Dto.User.UserResponse;
import prometheus.KhuT.Service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    @PostMapping("/v1/login")
    public BaseResponseDto<UserResponse.UserCreateResponse> login(@RequestBody UserRequest.UserCreateRequest userCreateRequest){
        System.out.println("userCreateRequest. = " + userCreateRequest.getName());
        UserResponse.UserCreateResponse joined = userService.join(userCreateRequest);
        return BaseResponseDto.onSuccess(joined);
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signup(
            @Valid @RequestBody UserDto userDto
    ) {
        return ResponseEntity.ok(userService.signup(userDto));
    }

    @GetMapping("/user")
//    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<User> getMyUserInfo() {
        return ResponseEntity.ok(userService.getMyUserWithAuthorities().get());
    }

    @GetMapping("/user/{username}")
//    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<User> getUserInfo(@PathVariable String username) {
        return ResponseEntity.ok(userService.getUserWithAuthorities(username).get());
    }


}
