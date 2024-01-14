package prometheus.KhuT.Dto.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserRequest {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserCreateRequest{
        String name;
        String email;
    }
}
