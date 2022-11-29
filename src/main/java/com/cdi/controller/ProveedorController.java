package com.cdi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cdi.model.Proveedor;
import com.cdi.repository.IProveedorRepository;

@Controller
public class ProveedorController {
	@Autowired
	private IProveedorRepository provRepo;

	@GetMapping("/proveedor/cargar")
	public String abrirPagProv(Model model) {
		model.addAttribute("proveedor", new Proveedor());
		model.addAttribute("lstProveedores", provRepo.findAll());
		// enviar listado proveedores
		return "mantproveedor";
	}

	@PostMapping("/proveedor/editar")
	public String cargarProveedor(@ModelAttribute Proveedor p, Model model) {
		Proveedor prov = provRepo.findById(p.getIdproveedor()).get();
		model.addAttribute("proveedor", prov);
		model.addAttribute("lstProveedores", provRepo.findAll()); 
		return "mantproveedor";
	}
	
	
	@PostMapping("/proveedor/grabar")
	public String leerPagProv(@ModelAttribute Proveedor proveedor, 
				  Model model) {
		try {
			provRepo.save(proveedor); 
			model.addAttribute("mensaje", "Proveedor agregado");
			model.addAttribute("clasemensaje", "alert alert-success");
		} catch (Exception e) {
			model.addAttribute("mensaje", "Error al registrar Proveedor");
			model.addAttribute("clasemensaje", "alert alert-danger");
		}
		
		model.addAttribute("lstProveedores", provRepo.findAll()); 
		return "mantproveedor";
	}
}
