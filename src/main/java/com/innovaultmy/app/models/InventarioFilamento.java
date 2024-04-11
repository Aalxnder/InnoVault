package com.innovaultmy.app.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Entity
@Table(name ="inventariofilamento")
public class InventarioFilamento  {

    @Getter
    @Setter
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter
    @Column(name = "Nombre")
    private String nombre;

    @Getter @Setter
    @Column(name = "Tipo_de_Filamento")
    private String tipoDeFilamento;

    @Getter @Setter
    @Column(name = "Cantidad")
    private int cantidad;

    @Getter @Setter
    @Column(name = "Color")
    private String color;

    @Getter @Setter
    @Column(name = "Notas")
    private String notas;

    @Getter @Setter
    @Column(name = "fecha_edicion")
    private Date fechaEdicion;
}