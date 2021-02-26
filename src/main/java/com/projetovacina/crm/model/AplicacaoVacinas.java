package com.projetovacina.crm.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Email;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Entity
public class AplicacaoVacinas implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@Column(nullable = false)
	private String nomeVacina;

	@SuppressWarnings("deprecation")
	@Column(nullable = false, unique = true)
	@Email
	private String email;

	@Column(name = "dataVacina", nullable = false)
	private LocalDate dataVacina;

	@Component
	public class LocalDateSpringConverter implements Converter<String, LocalDate> {

		@Override
		public LocalDate convert(String value) {
			if (value != null) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				return LocalDate.parse(value, formatter);
			} else {
				return null;
			}
		}

	}

	

	public LocalDate getDataVacina() {
		return dataVacina;
	}

	public void setDataVacina(LocalDate dataVacina) {
		this.dataVacina = dataVacina;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNomeVacina() {
		return nomeVacina;
	}

	public void setNomeVacina(String nomeVacina) {
		this.nomeVacina = nomeVacina;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
