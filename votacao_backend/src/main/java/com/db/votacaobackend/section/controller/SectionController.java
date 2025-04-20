package com.db.votacaobackend.section.controller;

import com.db.votacaobackend.agenda.dto.AgendaDTO;
import com.db.votacaobackend.agenda.mapper.AgendaMapper;
import com.db.votacaobackend.agenda.model.Agenda;
import com.db.votacaobackend.section.dto.CreateSectionDTO;
import com.db.votacaobackend.section.dto.SectionDetailsDTO;
import com.db.votacaobackend.section.service.SectionService;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/section")
@AllArgsConstructor
public class SectionController {

  private final SectionService service;
  private final AgendaMapper agendaMapper;

  @PostMapping
  @Operation(
      summary = "Create section"
  )
  public ResponseEntity<SectionDetailsDTO> createSection(@RequestBody CreateSectionDTO section) {
    SectionDetailsDTO savedSection = service.createSection(section);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedSection);
  }

  @GetMapping("/open")
  @Operation(
      summary = "List open sections"
  )
  public ResponseEntity<List<SectionDetailsDTO>> listOpenSections() {
    List<SectionDetailsDTO> openSections = service.listOpenSections();
    return ResponseEntity.status(HttpStatus.OK).body(openSections);
  }

  @GetMapping
  @Operation(
      summary = "List all sections"
  )
  public ResponseEntity<List<SectionDetailsDTO>> listAllSessions() {
    List<SectionDetailsDTO> openSections = service.listAllSessions();
    return ResponseEntity.status(HttpStatus.OK).body(openSections);
  }
  @GetMapping("/availiable-agendas")
  public ResponseEntity<List<AgendaDTO>> listAllAvailiableAgendas(){
    List<Agenda> availiableAgendas = service.listAllAvailiableAgendas();
    List<AgendaDTO> availiableAgendasDto = availiableAgendas.stream()
        .map(agendaMapper::toDto)
        .toList();
    return ResponseEntity.status(HttpStatus.OK).body(availiableAgendasDto);
  }
}
