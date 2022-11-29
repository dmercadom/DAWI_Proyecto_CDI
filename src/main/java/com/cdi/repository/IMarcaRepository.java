package com.cdi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdi.model.Marca;

@Repository
public interface IMarcaRepository extends JpaRepository<Marca, Integer>{

}
