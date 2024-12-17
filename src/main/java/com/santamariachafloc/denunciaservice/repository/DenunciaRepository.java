package com.torrescorrea.infraccionservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.torrescorrea.infraccionservice.entity.Infraccion;

@Repository
public interface InfraccionRepository extends JpaRepository<Infraccion, Integer> {
    List<Infraccion> findByDni(String dni);
}
