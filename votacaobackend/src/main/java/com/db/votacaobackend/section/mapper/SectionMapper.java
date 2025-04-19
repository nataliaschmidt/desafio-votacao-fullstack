package com.db.votacaobackend.section.mapper;

import com.db.votacaobackend.section.dto.CreateSectionDTO;
import com.db.votacaobackend.section.dto.SectionDetailsDTO;
import com.db.votacaobackend.section.model.Section;
import org.springframework.stereotype.Component;

@Component
public class SectionMapper {

  public Section toEntity(CreateSectionDTO createSectionDTO) {
    return Section.builder()
        .duration(createSectionDTO.duration())
        .build();
  }

  public SectionDetailsDTO toDto(Section section) {
    return new SectionDetailsDTO(
        section.getId(),
        section.getAgendaId(),
        section.getDuration(),
        section.getStart(),
        section.getEnd()
    );
  }
}
