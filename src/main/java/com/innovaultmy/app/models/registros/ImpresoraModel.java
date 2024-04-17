package com.innovaultmy.app.models.registros;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "ImpresorasRegistros")
public class ImpresoraModel
{
    @Setter @Getter
    @Id
    @Column(name = "idImpresora")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Setter @Getter
    @Column(name = "numeroImpresora")
    @NotNull
    private String numImpresora;

    @Setter @Getter
    @NotNull
    @Column(name = "tipoImpresora")
    private String tipo;

    @Setter @Getter
    @NotNull
    @Column(name = "marcaImpresora")
    private String marca;

    @Setter @Getter
    @NotNull
    @Column(name = "estatusImpresora")
    private String estatus;

    @Getter @Setter
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "fechaAgregado")
    private Date fechaAgregado;

    public ImpresoraModel(Integer id, String numImpresora, String tipo, String marca, String estatus, Date fechaAgregado) {
        super();
        this.id = id;
        this.numImpresora = numImpresora;
        this.tipo = tipo;
        this.marca = marca;
        this.estatus = estatus;
        this.fechaAgregado = fechaAgregado;
    }

    public ImpresoraModel(String numImpresora, String tipo, String marca, String estatus, Date fechaAgregado) {
        super();
        this.numImpresora = numImpresora;
        this.tipo = tipo;
        this.marca = marca;
        this.estatus = estatus;
        this.fechaAgregado = fechaAgregado;
    }

    public ImpresoraModel() {
        super();
    }
}
