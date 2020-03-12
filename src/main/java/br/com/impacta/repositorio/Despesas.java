package br.com.impacta.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.impacta.model.Despesa;

public interface Despesas extends JpaRepository<Despesa, Long> {

}
