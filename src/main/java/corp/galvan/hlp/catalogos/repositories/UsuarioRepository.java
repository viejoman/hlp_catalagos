package corp.galvan.hlp.catalogos.repositories;

import corp.galvan.hlp.catalogos.domain.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    Usuario findByEmail(String email);

    Usuario findByUsuario(String usuario);

}
