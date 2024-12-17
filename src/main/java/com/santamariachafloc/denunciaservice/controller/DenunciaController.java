package com.santamariachafloc.denunciaservice.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.santamariachafloc.denunciaservice.entity.Denuncia;
import com.santamariachafloc.denunciaservice.service.DenunciaService;

@RestController
@RequestMapping("/api/v1/denuncias")
public class DenunciaController {

    @Autowired
    private DenunciaService service;

    @PostMapping
    public ResponseEntity<Denuncia> create(@RequestBody Denuncia denuncia) {
        Denuncia nuevaDenuncia = service.create(denuncia);
        return ResponseEntity.ok(nuevaDenuncia);
    }

    @GetMapping
    public ResponseEntity<List<Denuncia>> list(
            @RequestParam(value = "offset", defaultValue = "0") int offset,
            @RequestParam(value = "limit", defaultValue = "5") int limit) {
        List<Denuncia> denuncias = service.getAll();
        if (denuncias.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        int toIndex = Math.min(offset + limit, denuncias.size());
        return ResponseEntity.ok(denuncias.subList(offset, toIndex));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Denuncia> get(@PathVariable Integer id) {
        Denuncia denuncia = service.get(id);
        if (denuncia == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(denuncia);
    }

    @GetMapping("/usuario/{dni}")
    public ResponseEntity<List<Denuncia>> getByDni(@PathVariable String dni) {
        List<Denuncia> denuncias = service.getByDni(dni);
        if (denuncias.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(denuncias);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Denuncia> anular(@PathVariable Integer id) {
        Denuncia denuncia = service.get(id);
        if (denuncia == null) {
            return ResponseEntity.notFound().build();
        }
        denuncia.setEstado("Anulada");
        Denuncia denunciaAnulada = service.update(denuncia);
        return ResponseEntity.ok(denunciaAnulada);
    }
}
