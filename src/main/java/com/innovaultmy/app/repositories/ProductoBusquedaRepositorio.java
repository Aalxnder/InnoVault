package com.innovaultmy.app.repositories;

import com.innovaultmy.app.models.registros.InventarioFilamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductoBusquedaRepositorio extends JpaRepository<InventarioFilamento, Integer>
{
    @Query("SELECT d FROM InventarioFilamento d WHERE d.nombre LIKE %:nombre%")
    Page<InventarioFilamento>findByNombreProductoContaining(@Param("nombre") String nombre, Pageable pageable);

}
