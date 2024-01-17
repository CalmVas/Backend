package prometheus.KhuT.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
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

    @Column
    private String name;

    @Enumerated(EnumType.STRING)
    private Part part;

    @Column
    private String description;

    @Builder
    public Massage(String name, Part part, String description){
        this.name = name;
        this.part = part;
        this.description = description;
    }

}
