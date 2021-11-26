package br.ifpe.web2.DAO;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ifpe.web2.model.Grupo;

@Repository
public interface GrupoDAO extends JpaRepository<Grupo, Integer>{
	
	public List<Grupo> findByDataExpiracao(LocalDate dataExpiracao);
	
	public Grupo findByNome(String nome);
}