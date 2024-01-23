package prometheus.KhuT.Converter.User;

import prometheus.KhuT.Domain.Role;
import prometheus.KhuT.Domain.User;
import prometheus.KhuT.Dto.User.UserRequest;
import prometheus.KhuT.Dto.User.UserResponse;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;

public class UserConverter {
    public static UserResponse.UserCreateResponse toUserCreateResponse(User user){
        return UserResponse.UserCreateResponse.builder()
                .id(user.getUserId())
                .name(user.getUsername())
                .build();
    }

    public static User toUserEntity(UserRequest.UserCreateRequest userCreateRequest){
        return User.builder()
                .username(userCreateRequest.getName())
                .email(userCreateRequest.getEmail())
                .createdAt(LocalDateTime.now())
                .roles(new ArrayList<>(Collections.singleton(Role.USER.toString())))
                .build();
    }
}
