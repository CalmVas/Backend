package prometheus.KhuT.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BeforeAndAfter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "before_and_after_id")
    private Long id;

    private String beforeSrc;

    private String afterSrc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
