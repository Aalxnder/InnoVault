package com.innovaultmy.app.service;

import com.innovaultmy.app.models.InventarioFilamento;
import com.innovaultmy.app.repositories.InventarioFilamentoRepositorie;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ImpInventarioFilamentoService implements InventarioFilamentoService {

    private final InventarioFilamentoRepositorie filamentoRepositorie;
    public ImpInventarioFilamentoService(InventarioFilamentoRepositorie filamentoRepositorie) {
        this.filamentoRepositorie = filamentoRepositorie;
    }

    @Override
    @Transactional
    public void registrarNuevoFilamento(String nombre, String tipoDeFilamento, int cantidad, String color, String notas) {
        InventarioFilamento nuevoFilamento = new InventarioFilamento();
        nuevoFilamento.setNombre(nombre);
        nuevoFilamento.setTipoDeFilamento(tipoDeFilamento);
        nuevoFilamento.setCantidad(cantidad);
        nuevoFilamento.setColor(color);
        nuevoFilamento.setNotas(notas);
        nuevoFilamento.setFechaEdicion(new Date());

        filamentoRepositorie.save(nuevoFilamento);
    }

    @Override
    @Transactional(readOnly = true)
    public List<InventarioFilamento> listaFilamentos() {
        return filamentoRepositorie.findAll();
    }

    @Override
    @Transactional
    public void borrar(InventarioFilamento filamento) {
        filamentoRepositorie.delete(filamento);
    }

    @Override
    @Transactional(readOnly = true)
    public InventarioFilamento buscarPorId(Long id) {
        return filamentoRepositorie.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void actualizarFilamento(InventarioFilamento filamento) {
        filamentoRepositorie.save(filamento);
    }
}
