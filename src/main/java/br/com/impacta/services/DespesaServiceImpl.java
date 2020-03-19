package br.com.impacta.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.impacta.models.Despesa;
import br.com.impacta.repositorio.DespesaRepository;

@Service
public class DespesaServiceImpl implements DespesaService{

	@Autowired
	private DespesaRepository despesaRepository;
	
	@Override
	public void salvar(Despesa despesas) {
		despesaRepository.save(despesas);
		
	}

	@Override
	public List<Despesa> listarDespesas() {		
		return despesaRepository.findAll();
	}

	@Override
	public void deletarPorId(Long codigo) {
		despesaRepository.deleteById(codigo);
		
	}

	@Override
	public Despesa buscarPoId(Long codigo) {		
		Optional<Despesa> optional = despesaRepository.findById(codigo);
		
		if(optional.isPresent()) {
			return optional.get();
		}
		
		return null;
	}

}
