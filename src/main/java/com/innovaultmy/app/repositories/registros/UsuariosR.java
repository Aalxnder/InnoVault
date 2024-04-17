
package com.innovaultmy.app.repositories.registros;

import com.innovaultmy.app.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosR extends JpaRepository<Usuario, Long>
{

}