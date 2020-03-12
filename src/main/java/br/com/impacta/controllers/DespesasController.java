package br.com.impacta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.impacta.model.Despesa;
import br.com.impacta.repositorio.Despesas;

@Controller
@RequestMapping("/despesas")
public class DespesasController {
	
	@Autowired
	private Despesas despesas;
	
	@RequestMapping("/nova")
	public String novaDespesa() {
		return "despesas/cadastro"; 
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvar(Despesa despesa) {
		despesas.save(despesa);
		System.out.println(("Despesa gravada : " + despesa.getDescricao()));
		return "despesas/cadastro";
	}

}
