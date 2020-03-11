package br.com.impacta.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/despesas")
public class DespesasController {
	
	@RequestMapping("/nova")
	public String novaDespesa() {
		return "despesas/cadastro";
	}

}
