package corp.galvan.hlp.catalogos.controllers;

import corp.galvan.hlp.catalogos.domain.Menu;
import corp.galvan.hlp.catalogos.model.MenuModel;
import corp.galvan.hlp.catalogos.model.hlpItemMenuModel;
import corp.galvan.hlp.catalogos.model.hlpMenuModel;
import corp.galvan.hlp.catalogos.services.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService _menuService;

    Logger _log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public void setInhibidorService(MenuService p__menuService) {
        this._menuService = p__menuService;
    }

    @RequestMapping(value = "/hlp/show/{idgrupo}", method = RequestMethod.GET)
    public MenuModel getMenuPrincipalHLP(@PathVariable("idgrupo") Long p__idgrupo) {
        MenuModel _menuModel = new MenuModel();

        List<hlpMenuModel> _listMenuModel = new ArrayList<>();
        List<hlpItemMenuModel> _listItemMenuModel = new ArrayList<>();
        List<Menu> _listMenu = _menuService.getMenuByIdGrupo(p__idgrupo);

        _menuModel.setSuccess(true);

        if (_listMenu.isEmpty()) {
            _menuModel.setMessage("No existe menu para el grupo " + p__idgrupo);
        } else {
            _menuModel.setMessage("Se encontraron " + _listMenu.size() + " Seccion(es) para el Menu del Grupo " + p__idgrupo);
            for (Menu _menuAux : _listMenu) {
                if (_menuAux.getIdmenuparent() == null) {

                    hlpMenuModel _test = new hlpMenuModel();
                    _test.setId(_menuAux.getIdmenu());
                    _test.setIconCls(_menuAux.getIconcls());
                    _test.setText(_menuAux.getTexto());

                    _listItemMenuModel = new ArrayList<>();

                    for (Menu _itemMenuAux : _listMenu) {

                        if (_itemMenuAux.getIdmenuparent() == _menuAux.getIdmenu()) {
                            hlpItemMenuModel _testLeaf = new hlpItemMenuModel();
                            _testLeaf.setId(_itemMenuAux.getIdmenu());
                            _testLeaf.setText(_itemMenuAux.getTexto());
                            _testLeaf.setIconCls(_itemMenuAux.getIconcls());
                            _testLeaf.setClassName(_itemMenuAux.getClassname());
                            _testLeaf.setMenu_id(_itemMenuAux.getIdmenuparent());
                            _testLeaf.setLeaf(true);
                            _listItemMenuModel.add(_testLeaf);
                        }
                    }

                    _test.setItems(_listItemMenuModel);
                    _listMenuModel.add(_test);
                }
            }
        }

        _menuModel.setCode("200");
        _menuModel.setData(_listMenuModel);

        return _menuModel;
    }

}
