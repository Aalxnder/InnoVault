package com.innovaultmy.app.models.registros;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

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
    @NotNull
    private String nombre;

    @Getter @Setter
    @NotNull
    @Column(name = "Tipo_de_Filamento")
    private String tipoDeFilamento;

    @Getter @Setter
    @NotNull
    @Column(name = "Cantidad")
    private int cantidad;

    @Getter @Setter
    @NotNull
    @Column(name = "Color")
    private String color;

    @Getter @Setter
    @NotNull
    @Column(name = "Notas")
    private String notas;

    @Getter @Setter
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "fecha_edicion")
    private Date fechaEdicion;

    public InventarioFilamento(Long id, String nombre, String tipoDeFilamento, int cantidad, String color, String notas, Date fechaEdicion) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.tipoDeFilamento = tipoDeFilamento;
        this.cantidad = cantidad;
        this.color = color;
        this.notas = notas;
        this.fechaEdicion = fechaEdicion;
    }

    public InventarioFilamento(String nombre, String tipoDeFilamento, int cantidad, String color, String notas, Date fechaEdicion) {
        super();
        this.nombre = nombre;
        this.tipoDeFilamento = tipoDeFilamento;
        this.cantidad = cantidad;
        this.color = color;
        this.notas = notas;
        this.fechaEdicion = fechaEdicion;
    }

    public InventarioFilamento() {
        super();
    }
}