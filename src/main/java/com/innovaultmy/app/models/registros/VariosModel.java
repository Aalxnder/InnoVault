package com.innovaultmy.app.models.registros;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name ="Miscelanea")
public class VariosModel {

    @Getter @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Getter @Setter
    @Column(name = "Nombre")
    private String nombre;

    @Getter @Setter
    @Column(name = "Cantidad")
    private int cantidad;

    @Getter @Setter
    @Column(name = "Categoria")
    private String categoria;

    @Getter @Setter
    @Column(name="Descripcion")
    private String descripcion;

    @Getter @Setter
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "Fecha_edicion")
    private Date fechaEdicion;

    public VariosModel(Long id, String nombre, int cantidad, String categoria,String descripcion, Date fechaEdicion) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.fechaEdicion = fechaEdicion;
    }

    public VariosModel(String nombre, int cantidad, String categoria,String descripcion, Date fechaEdicion) {
        super();
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.fechaEdicion = fechaEdicion;
    }

    public VariosModel() {
        super();
    }
}

