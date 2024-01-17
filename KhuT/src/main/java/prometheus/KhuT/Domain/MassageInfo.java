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
public class MassageInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "massageInfo_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "massage_id")
    private Massage massage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "massageplan_id")
    private MassagePlan massagePlan;

    @Builder
    public MassageInfo(Massage massage, MassagePlan massagePlan) {
        this.massage = massage;
        this.massagePlan = massagePlan;
    }
}