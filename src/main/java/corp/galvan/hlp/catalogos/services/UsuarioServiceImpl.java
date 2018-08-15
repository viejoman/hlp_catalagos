package corp.galvan.hlp.catalogos.services;

import corp.galvan.hlp.catalogos.domain.Oficina;
import corp.galvan.hlp.catalogos.domain.Usuario;
import corp.galvan.hlp.catalogos.domain.Grupo;

import corp.galvan.hlp.catalogos.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @PersistenceContext
    private EntityManager _entityManager;

    private UsuarioRepository _usuarioRepository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository p__ticketRepository) {
        this._usuarioRepository = p__ticketRepository;
    }

    @Override
    public List<Usuario> listAll() {
        List<Usuario> _inhibidores = new ArrayList<>();
        _usuarioRepository.findAll().forEach(_inhibidores::add);
        return _inhibidores;
    }

    @Override
    public Usuario getById(Long id) {
        return _usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario saveOrUpdate(Usuario model) {
        //model.setPassword(DigestUtils.sha256Hex(model.getPassword()));
        model = _usuarioRepository.save(model);
        return model;
    }

    @Override
    public void delete(Long id) {
        _usuarioRepository.deleteById(id);
    }


    @Override
    public Usuario findByEmail(String p__email) {
        return _usuarioRepository.findByEmail(p__email);

    }

    @Override
    public Usuario findByUsuario(String usuario) {
        return _usuarioRepository.findByUsuario(usuario);
    }

    @Override
    public List<Usuario> getUsuariosByIdGrupoSucursal(Long p__idgrupo, Long p__idsucursal) {

        List<Usuario> _listUsuarios = new ArrayList<>();

        List<Object[]> _listAux = _entityManager
                .createNamedQuery("funcGetUsuarioByGrupoSucursal")
                .setParameter( "p_idgrupo", p__idgrupo )
                .setParameter( "p_idsucursal", p__idsucursal )
                .getResultList();

        _listUsuarios = this.AddItems(_listAux);

        return _listUsuarios;
        //return new ArrayList<>();

    }

    @Override
    public List<Usuario> getUsuariosByIdOficina(Long p__idoficina) {

        List<Usuario> _listUsuarios = new ArrayList<>();

        List<Object[]> _listAux = _entityManager
                .createNamedQuery("funcGetUsuariosByIdOficina")
                .setParameter( "p_idoficina", p__idoficina )
                .getResultList();

        _listUsuarios = this.AddItems(_listAux);

        return _listUsuarios;

    }

    @Override
    public List<Usuario> getUsuariosByIdGrupo(Long p__idgrupo) {

        List<Usuario> _listUsuarios = new ArrayList<>();

        List<Object[]> _listAux = _entityManager
                .createNamedQuery("funcGetUsuariosByIdGrupo")
                .setParameter( "p_idgrupo", p__idgrupo )
                .getResultList();

        _listUsuarios = this.AddItems(_listAux);

        return _listUsuarios;

    }

    @Override
    public Usuario getUsuarioGrupo(Long p__idusuario) {

        Usuario _usuario = new Usuario();


        return _usuario;

    }

    private List<Usuario> AddItems(List<Object[]> _listAux) {

        List<Usuario> _listUsuarios = new ArrayList<>();

        if (!_listAux.isEmpty()) {

            for (Object[] _resultObject : _listAux) {
                Usuario _UsuarioAux = (Usuario)_resultObject[0];
                Grupo _GrupoAux = (Grupo)_resultObject[1];
                Oficina _OficinaAux = (Oficina) _resultObject[2];
                _UsuarioAux.setGrupo(_GrupoAux);
                _UsuarioAux.setOficina(_OficinaAux);
                _listUsuarios.add(_UsuarioAux);
            }

        }

        return _listUsuarios;

    }

}
