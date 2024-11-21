package halit.deveci.laboratuvar.raporlama.Controller;

import halit.deveci.laboratuvar.raporlama.DTO.LaborantDTO;
import halit.deveci.laboratuvar.raporlama.Service.LaborantService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/laborants")
@AllArgsConstructor
public class LaborantController {
    public final LaborantService laborantService;


    @PostMapping
    public ResponseEntity<LaborantDTO> addLaborant(@RequestBody LaborantDTO laborantDTO) {
        LaborantDTO savedLaborant = laborantService.create(laborantDTO);
        return ResponseEntity.ok(savedLaborant);
    }
    @GetMapping
    public ResponseEntity<List<LaborantDTO>> getAllLaborants() {
        List<LaborantDTO> laborants = laborantService.getAll();
        return ResponseEntity.ok(laborants);
    }
    /*
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLaborant(@PathVariable Long id) {
        laborantService.deleteLaborant(id);
        return ResponseEntity.noContent().build(); // HTTP 204 No Content
    }
    */
    @PutMapping("/{id}")
    public ResponseEntity<LaborantDTO> updateLaborant(@PathVariable Long id, @RequestBody LaborantDTO laborantDTO) {
        LaborantDTO updatedLaborant = laborantService.updateLaborant(id, laborantDTO);
        return ResponseEntity.ok(updatedLaborant);
    }
    @GetMapping("/{id}")
    public ResponseEntity<LaborantDTO> getLaborantById(@PathVariable Long id) {
        LaborantDTO laborantDTO = laborantService.getLaborantById(id);
        return ResponseEntity.ok(laborantDTO); // HTTP 200 OK
    }
    @GetMapping("/search")
    public ResponseEntity<List<LaborantDTO>> searchLaborants(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String surname,
            @RequestParam(required = false) String hospitalId) {
        try {
            List<LaborantDTO> laborants = laborantService.searchLaborants(name, surname, hospitalId);

            if (!laborants.isEmpty()) {
                return ResponseEntity.ok(laborants);
            } else {
                return ResponseEntity.noContent().build();
            }
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


}
