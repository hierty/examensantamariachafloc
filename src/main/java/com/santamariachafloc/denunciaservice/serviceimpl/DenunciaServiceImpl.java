package com.santamariachafloc.denunciaservice.serviceimpl;

import java.time.LocalDateTime; 
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.santamariachafloc.denunciaservice.entity.Denuncia;
import com.santamariachafloc.denunciaservice.repository.DenunciaRepository;
import com.santamariachafloc.denunciaservice.service.DenunciaService;

@Service
@Transactional
public class DenunciaServiceImpl implements DenunciaService {

    @Autowired
    private DenunciaRepository denunciaRepository;

    @Override
    public List<Denuncia> getAll() {
        return denunciaRepository.findAll();
    }

    @Override
    public Denuncia get(Integer id) {
        Optional<Denuncia> denuncia = denunciaRepository.findById(id);
        return denuncia.orElse(null);
    }

    @Override
    public Denuncia create(Denuncia denuncia) {
        denuncia.setCreatedAt(LocalDateTime.now()); // Fecha de creación
        denuncia.setEstado("Activa"); // Estado inicial
        return denunciaRepository.save(denuncia);
    }

    @Override
    public Denuncia update(Denuncia denuncia) {
        Optional<Denuncia> registroOpt = denunciaRepository.findById(denuncia.getId());
        if (registroOpt.isPresent()) {
            Denuncia registro = registroOpt.get();
            registro.setDni(denuncia.getDni());
            registro.setFecha(denuncia.getFecha());
            registro.setTitulo(denuncia.getTitulo());
            registro.setDireccion(denuncia.getDireccion());
            registro.setDescripcion(denuncia.getDescripcion());
            registro.setUpdatedAt(LocalDateTime.now()); // Fecha de actualización
            registro.setEstado(denuncia.getEstado());
            return denunciaRepository.save(registro);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Integer id) {
        denunciaRepository.deleteById(id);
    }

    @Override
    public List<Denuncia> getByDni(String dni) {
        return denunciaRepository.findByDni(dni);
    }
}
