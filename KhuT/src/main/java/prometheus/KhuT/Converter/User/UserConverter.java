package prometheus.KhuT.Converter.User;

import prometheus.KhuT.Domain.Role;
import prometheus.KhuT.Domain.User;
import prometheus.KhuT.Dto.User.UserRequest;
import prometheus.KhuT.Dto.User.UserResponse;

import java.time.LocalDateTime;

public class UserConverter {
    public static UserResponse.UserCreateResponse toUserCreateResponse(User user){
        return UserResponse.UserCreateResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .build();
    }

    public static User toUserEntity(UserRequest.UserCreateRequest userCreateRequest){
        return User.builder()
                .name(userCreateRequest.getName())
                .email(userCreateRequest.getEmail())
                .createdAt(LocalDateTime.now())
                .role(Role.USER)
                .build();
    }
}
