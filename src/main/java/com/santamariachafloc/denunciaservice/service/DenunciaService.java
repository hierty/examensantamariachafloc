package com.torrescorrea.infraccionservice.service;

import java.util.List;

import com.torrescorrea.infraccionservice.entity.Infraccion;

public interface InfraccionService {
    List<Infraccion> getAll();
    Infraccion get(Integer id);
    Infraccion create(Infraccion infraccion);
    Infraccion update(Infraccion infraccion);
    void delete(Integer id);
    List<Infraccion> getByDni(String dni);
}
