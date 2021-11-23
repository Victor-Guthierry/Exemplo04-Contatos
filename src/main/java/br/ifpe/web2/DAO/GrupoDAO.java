package br.ifpe.web2.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ifpe.web2.model.Grupo;

@Repository
public interface GrupoDAO extends JpaRepository<Grupo, Integer>{

}
