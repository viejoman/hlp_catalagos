package corp.galvan.hlp.catalogos.controllers;

import corp.galvan.hlp.catalogos.domain.Grupo;
import corp.galvan.hlp.catalogos.model.GrupoModel;
import corp.galvan.hlp.catalogos.services.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/grupo")
public class GrupoController {

    @Autowired
    private GrupoService _Service;

    @RequestMapping(value = "/hlp/show", method = RequestMethod.GET)
    public GrupoModel getAllInhibidoresHLP()
    {
        GrupoModel _ObjectModel = new GrupoModel();
        List<Grupo> _listObjectModel= _Service.listAll();
        _ObjectModel.setSuccess(true);
        if (_listObjectModel.isEmpty()) {
            _ObjectModel.setMessage("No existen registros");
        } else {
            _ObjectModel.setMessage("Se encontraron " + _listObjectModel.size() + " Grupo(s)");
        }
        _ObjectModel.setCode("200");
        _ObjectModel.setData(_listObjectModel);
        return _ObjectModel;
    }

}
