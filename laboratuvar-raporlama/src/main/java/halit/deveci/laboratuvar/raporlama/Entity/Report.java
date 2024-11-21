package halit.deveci.laboratuvar.raporlama.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String fileNumber; // Dosya numarası (benzersiz)

    private String patientName;

    @Column(nullable = false, length = 11)
    private String patientIdentityNumber; // Hasta kimlik numarası (TC, 11 haneli)

    private String diagnosisTitle;
    private String diagnosisDetails;
    private LocalDate reportDate;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String reportImage; // Fiziksel rapora ait bir fotoğraf

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "laborant_id", nullable = false)
    private Laborant laborant;
}
