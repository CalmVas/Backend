package prometheus.KhuT.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import prometheus.KhuT.Converter.StringList.StringListConverter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class User {
    @JsonIgnore
    @Id // primary key
    @Column(name = "user_id")
    // 자동 증가 되는
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "username", length = 50, unique = true)
    private String username;

    @JsonIgnore
    @Column(name = "email", length = 100)
    private String email;

    @JsonIgnore
    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "nickname", length = 50)
    private String nickname;

    @JsonIgnore
    @Column(name = "activated")
    private boolean activated;

    @Convert(converter = StringListConverter.class)
    private List<String> roles = new ArrayList<>();

    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    @Builder
    public User(String username, String email, String password, String nickname, boolean activated, List<String> roles, LocalDateTime createdAt) {
        this.username = username;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.activated = activated;
        this.roles = roles;
        this.createdAt = createdAt;
    }

}


