package com.torrescorrea.infraccionservice.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.torrescorrea.infraccionservice.entity.Infraccion;
import com.torrescorrea.infraccionservice.repository.InfraccionRepository;
import com.torrescorrea.infraccionservice.service.InfraccionService;

@Service
@Transactional
public class InfraccionServiceImpl implements InfraccionService {

    @Autowired
    private InfraccionRepository infraccionRepository;

    @Override
    public List<Infraccion> getAll() {
        return infraccionRepository.findAll();
    }

    @Override
    public Infraccion get(Integer id) {
        Optional<Infraccion> infraccion = infraccionRepository.findById(id);
        return infraccion.orElse(null);
    }

    @Override
    public Infraccion create(Infraccion infraccion) {
        return infraccionRepository.save(infraccion);
    }

    @Override
    @Transactional
    public Infraccion update(Infraccion infraccion) {
        Optional<Infraccion> registroOpt = infraccionRepository.findById(infraccion.getId());
        if (registroOpt.isPresent()) {
            Infraccion registro = registroOpt.get();
            registro.setDni(infraccion.getDni());
            registro.setFecha(infraccion.getFecha());
            registro.setTipo_infraccion(infraccion.getTipo_infraccion());
            registro.setUbicacion(infraccion.getUbicacion());
            registro.setDescripcion(infraccion.getDescripcion());
            registro.setMonto_multa(infraccion.getMonto_multa());
            registro.setEstado(infraccion.getEstado());
            return infraccionRepository.save(registro);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Integer id) {
        infraccionRepository.deleteById(id);
    }

    @Override
    public List<Infraccion> getByDni(String dni) {
        return infraccionRepository.findByDni(dni);
    }
}
