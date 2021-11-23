package br.ifpe.web2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.web2.model.Contato;
import br.ifpe.web2.model.Grupo;
import br.ifpe.web2.service.ContatoService;
import br.ifpe.web2.service.GrupoService;

@Controller
public class ContatoController {
	
	private List<Contato> contatos = new ArrayList<>();
	private List<Grupo> grupos = new ArrayList<>();
	
	@Autowired
	private ContatoService contatoService;
	
	@Autowired
	private GrupoService grupoService;

	@GetMapping("/exibirContato")
	public String exibirForm(Contato contato) {
		return "contatos-form";
	}
	
	@GetMapping("/novogrupo")
	public String novoGrupo(Grupo grupo) {
		return "novo-grupo";
	}
	
	@PostMapping("/salvarContato")
	public String salvarContato(Contato contato) {
		this.contatos.remove(contato);
		this.contatos.add(contato);
		this.contatoService.cadastrarContato(contato);
		System.out.println(contato);
		return "redirect:/listarContatos";
	}
	
	@PostMapping("/salvarGrupo")
	public String salvarGrupo(Grupo grupo) {
		this.grupos.remove(grupo);
		this.grupos.add(grupo);
		this.grupoService.cadastrarGrupo(grupo);
		System.out.println(grupo);
		return "redirect:/listarGrupos";
	}
	
	@GetMapping("/listarContatos")
	public String listarContatos(Model model) {
		model.addAttribute("lista", contatos);
		return "contatos-list";
	}
	
	@GetMapping("/listarGrupos")
	public String listarGrupos(Model model) {
		model.addAttribute("lista", grupos);
		return "listar-grupo";
	}
	
	@GetMapping("/removerContato")
	public String removerContato(String email) {
		Contato contatoParaRemover = null;
		for(Contato cont : this.contatos) {
			if(cont.getEmail().equals(email)) {
				contatoParaRemover = cont;
			}
		}
		if (contatoParaRemover != null) {
			this.contatos.remove(contatoParaRemover);
		}
		return "redirect:/listarContatos";
	}
	
	@GetMapping("/editarContato")
	public String editarContato(String email, Model model) {
		Contato contatoParaEditar = null;
		for(Contato cont : this.contatos) {
			if(cont.getEmail().equals(email)) {
				contatoParaEditar = cont;
			}
		}
		model.addAttribute("contato", contatoParaEditar);
		return "contatos-form";
	}
}
