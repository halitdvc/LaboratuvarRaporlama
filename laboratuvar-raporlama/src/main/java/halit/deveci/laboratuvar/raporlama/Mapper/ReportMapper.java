package halit.deveci.laboratuvar.raporlama.Mapper;

import halit.deveci.laboratuvar.raporlama.DTO.ReportDTO;
import halit.deveci.laboratuvar.raporlama.Entity.Report;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReportMapper {

    // Entity --> DTO
    @Mapping(source = "laborant",target = "laborant")
    ReportDTO toReportDTO(Report report);
    // DTO --> Entity
    @Mapping(source = "laborant", target = "laborant")
    Report toReportEntity(ReportDTO reportDTO);
}
