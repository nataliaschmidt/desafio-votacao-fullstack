package com.db.votacaobackend.section.dto;

import com.db.votacaobackend.agenda.model.Agenda;
import java.time.LocalDateTime;

public record SectionDetailsDTO(Long id, Agenda agendaId, Integer duration, LocalDateTime start,
                                LocalDateTime end) {

}
