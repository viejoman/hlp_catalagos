package corp.galvan.hlp.catalogos.services;

import corp.galvan.hlp.catalogos.domain.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> listAll();

    Usuario getById(Long id);

    Usuario saveOrUpdate(Usuario model);

    void delete(Long id);

    Usuario findByEmail(String email);

    Usuario findByUsuario(String usuario);

    List<Usuario> getUsuariosByIdGrupoSucursal(Long p__idgrupo, Long p__idsucursal);

    List<Usuario> getUsuariosByIdOficina(Long p__idoficina);

    List<Usuario> getUsuariosByIdOpcion(Long p__idopcion, Long p__idgrupo, Long p__idoficina);

    List<Usuario> getUsuariosByIdGrupo(Long p__idgrupo);

    Usuario getUsuarioGrupo(Long p__idusuario);

}
