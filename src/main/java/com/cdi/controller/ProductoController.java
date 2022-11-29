package com.cdi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cdi.model.Producto;
import com.cdi.repository.ICategoriaRepository;
import com.cdi.repository.IEstadoRepository;
import com.cdi.repository.IGeneroRepository;
import com.cdi.repository.IMarcaRepository;
import com.cdi.repository.IProductoRepository;
import com.cdi.repository.IProveedorRepository;


@Controller
public class ProductoController {
	// llamar al repositorio de Categorias
		@Autowired
		private IMarcaRepository repomarca;
		
		@Autowired
		private IProductoRepository repoprod;
		
		@Autowired
		private IEstadoRepository repoest;
		
		@Autowired
		private IGeneroRepository repogen;
		
		@Autowired
		private ICategoriaRepository repocat;
		
		@GetMapping("/cargarProd")
		public String abrirPagProductos(Model model ) {
			// enviar un nuevo obj de Producto
			model.addAttribute("producto", new Producto());
			// enviar un listado de las marcas -> generar Combo
			model.addAttribute("lstMarcas", repomarca.findAll());
			model.addAttribute("lstGenero", repogen.findAll());
			model.addAttribute("lstEstado", repoest.findAll());
			model.addAttribute("lstCategoria", repocat.findAll());
			// enviar un listado de los Proveedores --> generar combo
			model.addAttribute("txtbtn","Registrar");
			return "mantproductos";
		}
		
		@PostMapping("/grabar")
		public String grabarPagProductos(@ModelAttribute Producto producto, Model model) {
			System.out.println(producto);  	// lee el obj Producto
			// grabar en la tabla
			try {
				repoprod.save(producto);
				// muestra mensaje de éxito
				model.addAttribute("mensaje","Producto registrado");
				model.addAttribute("clase","alert alert-success");
			} catch (Exception e) {
				// muestra mensaje de error
				model.addAttribute("mensaje","Error al registrar Producto");
				model.addAttribute("clase","alert alert-danger");
			}
			// vuelve a listar los combos
			model.addAttribute("lstMarcas", repomarca.findAll());
			model.addAttribute("lstGenero", repogen.findAll());
			model.addAttribute("lstEstado", repoest.findAll());
			model.addAttribute("lstCategoria", repocat.findAll());
			
			return "mantproductos";
		}
		
		@GetMapping("/listado")
		public String listadoDeProductos(Model model ) {
			// Obtener un listado de todos los productos 
			model.addAttribute("lstProductos", repoprod.findAll());
			//y envia el estado a una pagina
			return "listado";
		}
		
		@PostMapping("/editar")
		public String buscarProductos(@ModelAttribute Producto p, Model model) {
			//Leer el codigo del producto seleccionado
			System.out.println(p);  
			//buscar y enviar la informacion de un producto segun el codigo seleccionado
			model.addAttribute("producto", repoprod.findById(p.getId_prod()) );
			//envia texto para el boton
			model.addAttribute("txtbtn","Actualizar");
			// vuelve a listar los combos
			model.addAttribute("lstMarcas", repomarca.findAll());
			model.addAttribute("lstGenero", repogen.findAll());
			model.addAttribute("lstEstado", repoest.findAll());
			model.addAttribute("lstCategoria", repocat.findAll());
			return "mantproductos";
		}
		
}
