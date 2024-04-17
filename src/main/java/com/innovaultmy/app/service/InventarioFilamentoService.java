package com.innovaultmy.app.service;

import com.innovaultmy.app.models.registros.InventarioFilamento;

import java.util.List;

public interface InventarioFilamentoService {
    void registrarNuevoFilamento(String nombre, String tipoDeFilamento, int cantidad, String color, String notas);
    List<InventarioFilamento> listaFilamentos();

    void borrar (InventarioFilamento filamento);
    InventarioFilamento buscarPorId(Long id);

    void actualizarFilamento(InventarioFilamento filamento);
}
