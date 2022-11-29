package com.cdi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdi.model.Categoria;

public interface ICategoriaRepository extends JpaRepository<Categoria, Integer>{

}
