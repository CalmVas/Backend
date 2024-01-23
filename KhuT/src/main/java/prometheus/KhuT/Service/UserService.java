package prometheus.KhuT.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import prometheus.KhuT.Converter.User.UserConverter;
import prometheus.KhuT.Domain.Role;
import prometheus.KhuT.Domain.User;
import prometheus.KhuT.Dto.User.UserDto;
import prometheus.KhuT.Dto.User.UserRequest;
import prometheus.KhuT.Dto.User.UserResponse;
import prometheus.KhuT.Repository.UserRepository;
import prometheus.KhuT.util.SecurityUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public UserResponse.UserCreateResponse join(UserRequest.UserCreateRequest userCreateRequest){
        System.out.println("userCreateRequest = " + userCreateRequest.getName());
        User user = userRepository.findByEmail(userCreateRequest.getEmail())
                .orElseGet(() -> userRepository.save(UserConverter.toUserEntity(userCreateRequest)));

        return UserConverter.toUserCreateResponse(user);
    }

    @Transactional
    public User signup(UserDto userDto) {
        if (userRepository.findOneWithRolesByUsername(userDto.getUsername()).orElse(null) != null) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다.");
        }

        // 가입되어 있지 않은 회원이면,
        // 유저 정보를 만들어서 save
        User user = User.builder()
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .password(passwordEncoder.encode(userDto.getEmail()))
                .nickname(userDto.getNickname())
                .roles(new ArrayList<>(Collections.singleton(Role.USER.toString())))
                .activated(true)
                .build();

        return userRepository.save(user);
    }

    // 유저,권한 정보를 가져오는 메소드
    @Transactional(readOnly = true)
    public Optional<User> getUserWithAuthorities(String username) {
        return userRepository.findOneWithRolesByUsername(username);
    }

    // 현재 securityContext에 저장된 username의 정보만 가져오는 메소드
    @Transactional(readOnly = true)
    public Optional<User> getMyUserWithAuthorities() {
        return SecurityUtil.getCurrentUsername()
                .flatMap(userRepository::findOneWithRolesByUsername);
    }

}
