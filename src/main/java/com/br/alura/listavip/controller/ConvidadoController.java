package com.br.alura.listavip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.br.alura.listavip.model.Convidado;
import com.br.alura.listavip.service.ConvidadoService;

import br.com.alura.sendmail.service.EmailService;

@Controller
public class ConvidadoController {

	@Autowired
	private ConvidadoService service;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("listaconvidados")
	public String listaConvidados(Model model) {
		addAttributeConvidados(model);
		return "listaconvidados";
	}

	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public String salvar(@RequestParam("nome") String nome, @RequestParam("email") String emai,
			@RequestParam("telefone") String telefone, Model model) {
		Convidado convidado = new Convidado(nome, emai, telefone);
		service.save(convidado);

		new EmailService().send(convidado.getNome(), convidado.getEmail());

		addAttributeConvidados(model);
		return "listaconvidados";
	}

	private void addAttributeConvidados(Model model) {
		Iterable<Convidado> convidados = service.findAll();
		model.addAttribute("convidados", convidados);
	}
}
