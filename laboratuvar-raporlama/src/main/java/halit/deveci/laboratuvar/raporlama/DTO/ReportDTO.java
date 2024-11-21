package halit.deveci.laboratuvar.raporlama.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record ReportDTO(
        Long id,
        String fileNumber,
        @NotBlank(message = "Hasta adı boş olamaz")
        String patientName,
        @Size(min = 11, max = 11, message = "TC kimlik numarası 11 haneli olmalıdır")
        String patientIdentityNumber,
        String diagnosisTitle,
        String diagnosisDetails,
        LocalDate reportDate,
        String reportImage,
        LaborantDTO laborant
) {
}
