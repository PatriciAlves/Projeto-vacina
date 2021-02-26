package com.projetovacina.crm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.projetovacina.crm.model.AplicacaoVacinas;
import com.projetovacina.crm.repository.VacinaRepository;

@RestController // recebe requisições
@RequestMapping("/vacinas")

public class VacinaController {

	@Autowired

	private VacinaRepository vacinaRepository;

	@GetMapping
	public List<AplicacaoVacinas> listarVacina() {
		return vacinaRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AplicacaoVacinas adicionar(@RequestBody @Valid 
			AplicacaoVacinas aplicacaoVacinas) {
		return vacinaRepository.save(aplicacaoVacinas);
	}

}
