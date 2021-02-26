package com.projetovacina.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetovacina.crm.model.AplicacaoVacinas;

@Repository
public interface VacinaRepository extends JpaRepository<AplicacaoVacinas, Long> {

}
