package halit.deveci.laboratuvar.raporlama.Service;

import halit.deveci.laboratuvar.raporlama.DTO.LaborantDTO;
import halit.deveci.laboratuvar.raporlama.Entity.Laborant;
import halit.deveci.laboratuvar.raporlama.Mapper.LaborantMapper;
import halit.deveci.laboratuvar.raporlama.Repository.LaborantRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.criteria.Predicate;


@Service
@AllArgsConstructor
public class LaborantService {
    private final LaborantRepository laborantRepository;
    private final LaborantMapper laborantMapper;

    public LaborantDTO create(LaborantDTO laborantDTO) {
        Laborant laborant = laborantMapper.toLaborantEntity(laborantDTO);
        laborantRepository.save(laborant);
        return laborantMapper.toLaborantDTO(laborant);
    }

    public List<LaborantDTO> getAll() {
        return laborantRepository.findAll().stream().map(laborantMapper::toLaborantDTO).toList();
    }

    public void deleteLaborant(Long id) {
        if (!laborantRepository.existsById(id)) {
            throw new RuntimeException("Laborant not found with id: " + id);
        }
        laborantRepository.deleteById(id);
    }
    public LaborantDTO updateLaborant(Long id, LaborantDTO laborantDTO) {
        Laborant existingLaborant = laborantRepository.findById(id).orElseThrow(() -> new RuntimeException("Laborant not found with id: " + id));

        existingLaborant.setName(laborantDTO.name());
        existingLaborant.setSurname(laborantDTO.surname());
        existingLaborant.setHospitalId(laborantDTO.hospitalId());

        Laborant updatedLaborant = laborantRepository.save(existingLaborant);
        return laborantMapper.toLaborantDTO(updatedLaborant);
    }
    public LaborantDTO getLaborantById(Long id) {
        return laborantRepository.findById(id)
                .map(laborantMapper::toLaborantDTO)
                .orElseThrow(() -> new RuntimeException("Laborant not found with id: " + id));
    }
    public List<LaborantDTO> searchLaborants(String name, String surname, String hospitalId) {
        Specification<Laborant> specification = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (name != null && !name.isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("name"),"%"+name+"%"));
            }

            if (surname != null && !surname.isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("surname"), "%" + surname + "%"));
            }

            if (hospitalId != null && !hospitalId.isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("hospitalId"), hospitalId));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        List<Laborant> laborants = laborantRepository.findAll(Specification.where(specification));

        return laborants.stream().map(laborantMapper::toLaborantDTO).toList();
    }

}
