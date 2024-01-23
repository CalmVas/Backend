package prometheus.KhuT.Dto.User;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

/**
 * @author : sblim
 * @version : 1.0.0
 * @package : com.karim.jwt.dto
 * @name : spring-basic-server
 * @date : 2023. 04. 27. 027 오후 2:31
 * @modifyed :
 * @description :
 **/

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @NotNull
    @Size(min = 3, max = 50)
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull
    @Size(min = 3, max = 100)
    private String email;

    @NotNull
    @Size(min = 3, max = 50)
    private String nickname;
}