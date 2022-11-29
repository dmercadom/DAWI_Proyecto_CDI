package com.cdi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdi.model.Proveedor;

@Repository
public interface IProveedorRepository extends JpaRepository<Proveedor, Integer>{

}