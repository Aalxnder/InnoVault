package com.innovaultmy.app.repositories.registros;

import com.innovaultmy.app.models.registros.InventarioFilamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface InventarioFilamentoRepositorie extends JpaRepository<InventarioFilamento, Long> {

}
