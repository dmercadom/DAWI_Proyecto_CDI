package com.cdi.controller;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.OutputStream;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.core.io.ResourceLoader;


@Controller
public class ReporteController {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private ResourceLoader resourceLoader; 
	
	@GetMapping("/listadoUsuarios")
	public void verReporteCarreras(HttpServletResponse response) {
		
		response.setHeader("Content-Disposition", "inline;");
		response.setContentType("application/pdf");
		try {
			String ru = resourceLoader.getResource("classpath:reportes/Usuario.jasper").getURI().getPath();
			JasperPrint jasperPrint = JasperFillManager.fillReport(ru, null, dataSource.getConnection());
			OutputStream outStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
			} catch (Exception e) {
			e.printStackTrace();
			}
	}
	
	@GetMapping("/listadoProductos")
	public void verReporteReservas(HttpServletResponse response) {
		
		response.setHeader("Content-Disposition", "inline;");
		response.setContentType("application/pdf");
		try {
			String ru = resourceLoader.getResource("classpath:reportes/Productos.jasper").getURI().getPath();
			JasperPrint jasperPrint = JasperFillManager.fillReport(ru, null, dataSource.getConnection());
			OutputStream outStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
			} catch (Exception e) {
			e.printStackTrace();
			}
	}
	
	
}
