package com.br.alura.listavip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.alura.listavip.model.Convidado;
import com.br.alura.listavip.repository.ConvidadoRepository;

@Service
public class ConvidadoService {

	@Autowired
	private ConvidadoRepository repository;

	public Iterable<Convidado> findAll() {
		return repository.findAll();
	}

	public void save(Convidado convidado) {
		repository.save(convidado);
	}
}
