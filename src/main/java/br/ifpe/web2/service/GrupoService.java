package br.ifpe.web2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.web2.DAO.GrupoDAO;
import br.ifpe.web2.model.Grupo;

@Service
public class GrupoService {
	
	@Autowired
	private GrupoDAO grupoDAO;
	
	public void cadastrarGrupo(Grupo grupo) {
		this.grupoDAO.save(grupo);
	}
}
