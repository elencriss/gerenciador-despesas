package br.com.impacta.services;

import java.util.List;

import br.com.impacta.models.Despesa;

public interface DespesaService {

	void salvar(Despesa despesas);
	
	List<Despesa> listarDespesas();
	 
	void deletarPorId(Long codigo);
	
	Despesa buscarPoId(Long codigo);

}
