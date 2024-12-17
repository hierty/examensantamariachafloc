package com.torrescorrea.infraccionservice.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.torrescorrea.infraccionservice.entity.Infraccion;
import com.torrescorrea.infraccionservice.service.InfraccionService;

@RestController
@RequestMapping("/api/v1/infracciones")
public class InfraccionController {

    @Autowired
    private InfraccionService service;

    @PostMapping
    public ResponseEntity<Infraccion> create(@RequestBody Infraccion infraccion) {
        Infraccion nuevaInfraccion = service.create(infraccion);
        return ResponseEntity.ok(nuevaInfraccion);
    }

    @GetMapping
    public ResponseEntity<List<Infraccion>> list(
            @RequestParam(value = "offset", defaultValue = "0") int offset,
            @RequestParam(value = "limit", defaultValue = "5") int limit) {
        List<Infraccion> infracciones = service.getAll();
        if (infracciones.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        int toIndex = Math.min(offset + limit, infracciones.size());
        return ResponseEntity.ok(infracciones.subList(offset, toIndex));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Infraccion> get(@PathVariable Integer id) {
        Infraccion infraccion = service.get(id);
        if (infraccion == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(infraccion);
    }

    @GetMapping("/usuario/{dni}")
    public ResponseEntity<List<Infraccion>> getByDni(@PathVariable String dni) {
        List<Infraccion> infracciones = service.getByDni(dni);
        if (infracciones.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(infracciones);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Infraccion> anular(@PathVariable Integer id) {
        Infraccion infraccion = service.get(id);
        if (infraccion == null) {
            return ResponseEntity.notFound().build();
        }
        infraccion.setEstado("Anulada");
        Infraccion infraccionAnulada = service.update(infraccion);
        return ResponseEntity.ok(infraccionAnulada);
    }
}
