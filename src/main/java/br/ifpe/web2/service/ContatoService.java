package br.ifpe.web2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.web2.DAO.ContatoDAO;
import br.ifpe.web2.model.Contato;

@Service
public class ContatoService {
	
	@Autowired
	private ContatoDAO contatoDAO;
	
	public void cadastrarContato(Contato contato) {
		this.contatoDAO.save(contato);
	}
}
