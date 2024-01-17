package prometheus.KhuT.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MassagePlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "massageplan_id")
    private Long id;

    @Column
    private Integer likes;

    @Column
    private String name;

    @Column
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public MassagePlan(Integer likes, String name, LocalDateTime createdAt, User user) {
        this.likes = likes;
        this.name = name;
        this.createdAt = createdAt;
        this.user = user;
    }
}
