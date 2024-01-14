package prometheus.KhuT.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Massage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "massage_id")
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Part part;

    private String description;

}
