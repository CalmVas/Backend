package prometheus.KhuT.Domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String name;

    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    private LocalDateTime createdAt;

    @Builder
    public User(String name, String email, Role role, LocalDateTime createdAt){
        this.name = name;
        this.email = email;
        this.role = role;
        this.createdAt = createdAt;
    }

}
