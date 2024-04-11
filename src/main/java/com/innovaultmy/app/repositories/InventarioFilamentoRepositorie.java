package com.innovaultmy.app.repositories;

import com.innovaultmy.app.models.InventarioFilamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface InventarioFilamentoRepositorie extends JpaRepository<InventarioFilamento, Long> {

}
