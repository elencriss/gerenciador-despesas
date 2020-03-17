package br.com.impacta.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.impacta.enums.Categoria;
import br.com.impacta.models.Despesa;
import br.com.impacta.services.DespesaService;

@Controller
@RequestMapping("/despesas")
public class DespesasController {
	
	private static final String VIEW = "despesas/cadastro";
	
	@Autowired
	private DespesaService despesaService;
	
	@RequestMapping("/nova")
	public ModelAndView novaDespesa(ModelAndView mv) {
		mv.setViewName(VIEW);
		return mv; 
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView despesas(ModelAndView mv) {
//		List<Despesa> todasDespesas = despesas.findAll();
		mv.setViewName("despesas/listagem");
//		mv.addObject("despesas", todasDespesas);
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView salvar(Despesa despesas, ModelAndView mv) {
		despesaService.salvar(despesas);
		mv.setViewName(VIEW);
		mv.addObject("mensagem", "Despesa salva com sucesso!");
		return mv;
	}
	
	@ModelAttribute("categorias")
	public List<Categoria> getCategorias() {
		return Arrays.asList(Categoria.values());
	}
	
//	@RequestMapping(value="{codigo}", method=RequestMethod.DELETE)
//	public String excluir(@PathVariable Long codigo) {
//		despesas.delete(codigo);
//		return "redirect:/despesas";
//	}

}
