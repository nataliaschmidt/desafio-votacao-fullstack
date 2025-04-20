package com.db.votacaobackend.vote.controller;

import com.db.votacaobackend.vote.dto.VoteCreateDTO;
import com.db.votacaobackend.vote.dto.VoteDetailDTO;
import com.db.votacaobackend.vote.dto.VoteResultsDTO;
import com.db.votacaobackend.vote.service.VoteService;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/vote")
@AllArgsConstructor
public class VoteController {

  private VoteService service;

  @PostMapping
  @Operation(
      summary = "Create vote"
  )
  public ResponseEntity<VoteDetailDTO> createVote(@RequestBody VoteCreateDTO vote) {
    VoteDetailDTO createdVote = service.createVote(vote);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdVote);
  }

  @GetMapping
  @Operation(
      summary = "List all votes"
  )
  public ResponseEntity<List<VoteDetailDTO>> listAllVotes() {
    List<VoteDetailDTO> openSections = service.listAllVotes();
    return ResponseEntity.status(HttpStatus.OK).body(openSections);
  }

  @GetMapping("/results/{sectionId}")
  public ResponseEntity<VoteResultsDTO> getVoteResults(@PathVariable("sectionId") Long sectionId) {
    VoteResultsDTO resultsDTO = service.listVotesFromSession(sectionId);
    return ResponseEntity.status(HttpStatus.OK).body(resultsDTO);
  }

}
