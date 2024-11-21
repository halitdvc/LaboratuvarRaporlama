package halit.deveci.laboratuvar.raporlama.Service;

import halit.deveci.laboratuvar.raporlama.DTO.ReportDTO;

import halit.deveci.laboratuvar.raporlama.Entity.Laborant;
import halit.deveci.laboratuvar.raporlama.Entity.Report;
import halit.deveci.laboratuvar.raporlama.Mapper.ReportMapper;
import halit.deveci.laboratuvar.raporlama.Repository.LaborantRepository;
import halit.deveci.laboratuvar.raporlama.Repository.ReportRepository;
import jakarta.persistence.criteria.Predicate;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ReportService {
    private final ReportRepository reportRepository;
    private final LaborantRepository laborantRepository;
    private final ReportMapper reportMapper;


    public ReportDTO createReport(ReportDTO reportDTO) {
        Report report = reportMapper.toReportEntity(reportDTO);
        reportRepository.save(report);
        return reportMapper.toReportDTO(report);

    }

    public List<ReportDTO> getAllReports() {
        return reportRepository.findAll().stream()
                .map(reportMapper::toReportDTO)
                .toList();
    }
    public void deleteReport(Long id) {
        if (!reportRepository.existsById(id)) {
            throw new RuntimeException("Report not found with id: " + id);
        }
        reportRepository.deleteById(id);
    }
    public ReportDTO updateReport(Long id, ReportDTO reportDTO) {
        Report existingReport = reportRepository.findById(id).orElseThrow(() -> new RuntimeException("Report not found with id: " + id));

        Laborant laborant = laborantRepository.findById(reportDTO.laborant().id()).orElseThrow(() -> new RuntimeException("Laborant not found with id: " + id));
        existingReport.setFileNumber(reportDTO.fileNumber());
        existingReport.setPatientName(reportDTO.patientName());
        existingReport.setPatientIdentityNumber(reportDTO.patientIdentityNumber());
        existingReport.setDiagnosisTitle(reportDTO.diagnosisTitle());
        existingReport.setDiagnosisDetails(reportDTO.diagnosisDetails());
        existingReport.setReportDate(reportDTO.reportDate());
        existingReport.setReportImage(reportDTO.reportImage());
        existingReport.setLaborant(laborant);

        Report updatedReport = reportRepository.save(existingReport);  // geri donen raporu return etmek daha dogru
        return reportMapper.toReportDTO(updatedReport);
    }
    public ReportDTO getReportById(Long id) {
        return reportRepository.findById(id)
                .map(reportMapper::toReportDTO)
                .orElseThrow(() -> new RuntimeException("Report not found with id: " + id));
    }
    public List<ReportDTO> searchReports(String patientName, String patientIdentityNumber, String laborantName, Sort sort) {
        Specification<Report> specification = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (patientName != null && !patientName.isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("patientName")), "%" + patientName.toLowerCase() + "%"));
            }

            if (patientIdentityNumber != null && !patientIdentityNumber.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("patientIdentityNumber"), patientIdentityNumber));
            }

            if (laborantName != null && !laborantName.isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.join("laborant").get("name")), "%" + laborantName.toLowerCase() + "%"));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        List<Report> reports = reportRepository.findAll(Specification.where(specification), sort);
        // DTO'ya dönüştürerek döndür
        return reports.stream().map(reportMapper::toReportDTO).toList();
    }

}
