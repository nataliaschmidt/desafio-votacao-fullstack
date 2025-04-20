package com.db.votacaobackend.vote.repository;

import com.db.votacaobackend.vote.model.Vote;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Long> {

  List<Vote> findBySectionId(Long sectionId);

  Vote findByCpfAndSectionId(String cpf, Long sectionId);
}
