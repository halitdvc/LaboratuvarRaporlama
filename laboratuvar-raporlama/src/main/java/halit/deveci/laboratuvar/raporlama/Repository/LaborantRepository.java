package halit.deveci.laboratuvar.raporlama.Repository;

import halit.deveci.laboratuvar.raporlama.Entity.Laborant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface LaborantRepository extends JpaRepository<Laborant, Long>, JpaSpecificationExecutor<Laborant> {
}
