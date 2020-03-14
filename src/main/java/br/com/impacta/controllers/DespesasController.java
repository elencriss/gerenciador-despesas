package br.com.impacta.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.impacta.model.Categoria;
import br.com.impacta.model.Despesa;
import br.com.impacta.repositorio.Despesas;

@Controller
@RequestMapping("/despesas")
public class DespesasController {
	
	@Autowired
	private Despesas despesas;
	
	@RequestMapping("/nova")
	public String novaDespesa() {
		return "CadastroDespesa"; 
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView despesas() {
		List<Despesa> todasDespesas = despesas.findAll();
		ModelAndView mv = new ModelAndView("ListagemDespesas");
		mv.addObject("despesas", todasDespesas);
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView salvar(Despesa despesa) {
		despesas.save(despesa);
		ModelAndView mv = new ModelAndView("CadastroDespesa");
		mv.addObject("mensagem", "Despesa salva com sucesso!");
		return mv;
	}
	
	@ModelAttribute("todasCategorias")
	public List<Categoria> todasCategorias() {
		return Arrays.asList(Categoria.values());
	}
	
	@RequestMapping(value="{codigo}", method=RequestMethod.DELETE)
	public String excluir(@PathVariable Long codigo) {
		despesas.delete(codigo);
		return "redirect:/despesas";
	}

}
