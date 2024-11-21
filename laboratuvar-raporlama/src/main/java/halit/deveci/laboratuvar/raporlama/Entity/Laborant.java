package halit.deveci.laboratuvar.raporlama.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Laborant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;

    @Column(unique = true, nullable = false, length = 7)
    private String hospitalId; // Hastane kimlik numarası (benzersiz ve 7 haneli)

    @OneToMany(mappedBy = "laborant", cascade = CascadeType.ALL)
    private List<Report> reports; // Laborantın yazdığı raporlar
}
