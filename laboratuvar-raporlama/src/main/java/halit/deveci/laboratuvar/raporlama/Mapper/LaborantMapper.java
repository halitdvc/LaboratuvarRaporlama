package halit.deveci.laboratuvar.raporlama.Mapper;

import halit.deveci.laboratuvar.raporlama.DTO.LaborantDTO;
import halit.deveci.laboratuvar.raporlama.Entity.Laborant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LaborantMapper {

    // Entity -> DTO
    LaborantDTO toLaborantDTO(Laborant laborant);

    // DTO -> Entity
    Laborant toLaborantEntity(LaborantDTO laborantDTO);
}
