package com.cdi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdi.model.Producto;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Integer>{

}
