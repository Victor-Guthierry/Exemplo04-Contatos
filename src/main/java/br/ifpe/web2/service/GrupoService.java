package br.ifpe.web2.service;

import java.util.Date;
import java.util.List;

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
	
	public List<Grupo> listarGrupos() {
		List<Grupo> listaGrupos = this.grupoDAO.findAll();
		return listaGrupos;
	}
	
	public Grupo nomeGrupo(String nomeGrupo) {
		Grupo grupo = this.grupoDAO.findByNome(nomeGrupo);
		return grupo;
	}
	
	public List<Grupo> grupoValido(List<Grupo> grupo) {
		Date data = (Date) grupoDAO.findByDataExpiracao(null);
		if (data.after(new Date())) {
			return (List<Grupo>) data;
			}
		return (List<Grupo>) data;
	}
	
}

