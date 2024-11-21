package halit.deveci.laboratuvar.raporlama.Controller;

import halit.deveci.laboratuvar.raporlama.DTO.ReportDTO;
import halit.deveci.laboratuvar.raporlama.Service.ReportService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
@AllArgsConstructor
public class ReportController {
    private final ReportService reportService;

    @PostMapping
    public ResponseEntity<ReportDTO> addReport(@RequestBody ReportDTO reportDTO) {
        ReportDTO savedReport = reportService.createReport(reportDTO);
        return ResponseEntity.ok(savedReport);
    }

    @GetMapping
    public ResponseEntity<List<ReportDTO>> getAllReports() {
        List<ReportDTO> reports = reportService.getAllReports();
        return ResponseEntity.ok(reports);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ReportDTO> updateReport(@PathVariable Long id, @RequestBody ReportDTO reportDTO) {
        ReportDTO updatedReport = reportService.updateReport(id, reportDTO);
        return ResponseEntity.ok(updatedReport);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable Long id) {
        reportService.deleteReport(id);
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }
    @GetMapping("/{id}")
    public ResponseEntity<ReportDTO> getReportById(@PathVariable Long id) {
        ReportDTO reportDTO = reportService.getReportById(id);
        return ResponseEntity.ok(reportDTO); // HTTP 200 OK
    }

    @GetMapping("/search")
    public ResponseEntity<List<ReportDTO>> searchReports(
            @RequestParam(required = false) String patientName,
            @RequestParam(required = false) String patientIdentityNumber,
            @RequestParam(required = false) String laborantName,
            @RequestParam(defaultValue = "reportDate") String sortBy,
            @RequestParam(defaultValue = "ASC") String direction) {
        try {
            // Arama işlemi
            Sort sort = Sort.by(Sort.Direction.fromString(direction), sortBy);
            List<ReportDTO> reports = reportService.searchReports(patientName, patientIdentityNumber, laborantName, sort);
            if (reports.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(reports);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


}
