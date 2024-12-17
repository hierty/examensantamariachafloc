package com.torrescorrea.infraccionservice.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "infracciones")
public class Infraccion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 8)
    private String dni;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Column(nullable = false, length = 20)
    private String tipo_infraccion;

    @Column(nullable = false, length = 200)
    private String ubicacion;

    @Column(length = 255)
    private String descripcion;

    @Column(nullable = false)
    private Double monto_multa;

    @Column(nullable = false, length = 20)
    private String estado;

    // Getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getTipo_infraccion() {
        return tipo_infraccion;
    }

    public void setTipo_infraccion(String tipo_infraccion) {
        this.tipo_infraccion = tipo_infraccion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getMonto_multa() {
        return monto_multa;
    }

    public void setMonto_multa(Double monto_multa) {
        this.monto_multa = monto_multa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}