package com.db.votacaobackend.section.service;

import com.db.votacaobackend.agenda.model.Agenda;
import com.db.votacaobackend.agenda.service.AgendaService;
import com.db.votacaobackend.section.dto.CreateSectionDTO;
import com.db.votacaobackend.section.dto.SectionDetailsDTO;
import com.db.votacaobackend.section.mapper.SectionMapper;
import com.db.votacaobackend.section.model.Section;
import com.db.votacaobackend.section.repository.SectionRepository;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SectionService {

  private final SectionRepository repository;
  private final AgendaService agendaService;
  private final SectionMapper mapper;

  public SectionDetailsDTO createSection(CreateSectionDTO section) {

    Agenda agenda = agendaService.getById(section.agendaId());

    Section newSession = createNewSection(section, agenda);

    Section newSection = repository.save(newSession);
    return mapper.toDto(newSection);
  }

  private static Section createNewSection(CreateSectionDTO section, Agenda agenda) {
    LocalDateTime start = LocalDateTime.now();
    int duration = section.duration() != null ? section.duration() : 1;

    return Section.builder()
        .start(start)
        .end(LocalDateTime.now().plusMinutes(duration))
        .duration(duration)
        .agendaId(agenda)
        .build();
  }

  public List<SectionDetailsDTO> listOpenSections() {
    return repository.findByEndAfter(LocalDateTime.now())
        .stream()
        .map(mapper::toDto)
        .toList();
  }
}
