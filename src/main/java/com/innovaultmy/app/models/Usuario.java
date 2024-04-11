package com.innovaultmy.app.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Usuario")
public class Usuario {

    @Getter @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter
    @Column(name = "Nombre", nullable = false, unique = true, length = 255)
    private String nombre;

    @Getter @Setter
    @Column(name = "Contrasenia", nullable = false, length = 255)
    private String contrasenia;


    @Getter @Setter
    @Column(name = "CodigoUniversitario", nullable = false)
    private int codigoUniversitario;

    @Getter @Setter
    @Column(name = "Permisos", length = 20)
    private String permisos;

    @Getter @Setter
    @Column(name = "Telefono", nullable = false)
    private int telefono;

    @Getter @Setter
    @Column(name = "Correo", length = 255)
    private String correo;


}