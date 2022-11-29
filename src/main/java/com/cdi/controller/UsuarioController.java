package com.cdi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import com.cdi.model.Usuario;
import com.cdi.repository.IUsuarioRepository;


@Controller
public class UsuarioController {
	
	@Autowired
	private IUsuarioRepository repousu;
	
	@GetMapping("/login")
	public String abrirPagLogin(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "Index";
	}
	
	
	@PostMapping("/validar")
	public String validarAcceso(Model model, @ModelAttribute Usuario usuario) {

		System.out.println(usuario);
		Usuario u = repousu.findByCorreoAndClave(usuario.getCorreo(), usuario.getClave());
		if (u == null) {
			model.addAttribute("mensaje","Usuario o clave incorrectos");
			model.addAttribute("clase","alert alert-danger");
			return "Index";
		}else {
			return "principal";
		}
		
	
	}
	
	
}
