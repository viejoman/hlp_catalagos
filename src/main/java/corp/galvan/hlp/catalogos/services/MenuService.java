package corp.galvan.hlp.catalogos.services;

import corp.galvan.hlp.catalogos.domain.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> listAll();

    Menu getById(Long id);

    Menu saveOrUpdate(Menu model);

    void delete(Long id);

    List<Menu> getMenuByIdGrupo(Long Idgrupo);
}
