package corp.galvan.hlp.catalogos.services;

import corp.galvan.hlp.catalogos.domain.Menu;
import corp.galvan.hlp.catalogos.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @PersistenceContext
    private EntityManager _entityManager;

    private MenuRepository _menuRepository;

    @Autowired
    public MenuServiceImpl(MenuRepository p__menuRepository) {
        this._menuRepository = p__menuRepository;
    }

    @Override
    public List<Menu> listAll() {
        List<Menu> _listMenu = new ArrayList<>();
        _menuRepository.findAll().forEach(_listMenu::add);
        return _listMenu;
    }

    @Override
    public Menu getById(Long id) {
        return _menuRepository.findById(id).orElse(null);
    }

    @Override
    public Menu saveOrUpdate(Menu model) {
        _menuRepository.save(model);
        return model;
    }

    @Override
    public void delete(Long id) {
        _menuRepository.deleteById(id);

    }

    @Override
    public List<Menu> getMenuByIdGrupo(Long p_IdGrupo) {

        List<Menu> _listMenu = new ArrayList<>();

        StoredProcedureQuery q = _entityManager.createNamedStoredProcedureQuery("obtenerMenuByIdGrupo");
        q.setParameter("idgrupo", p_IdGrupo);
        List<Menu> _listMenuTemp = q.getResultList();

        return _listMenuTemp;

    }

}
