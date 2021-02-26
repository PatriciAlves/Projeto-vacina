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
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.projetovacina.crm.model.Paciente;
import com.projetovacina.crm.repository.PacienteRepository;

@RestController // recebe requisições
@RestControllerAdvice
@RequestMapping("/pacientes") //mapea os endpoints

public class PacienteController {

	@Autowired 
	private PacienteRepository pacienteRepository;

	@GetMapping
	public List<Paciente> listar() {
		return pacienteRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Paciente adicionar(@RequestBody @Valid Paciente paciente) {
		return pacienteRepository.save(paciente);

	}

}
