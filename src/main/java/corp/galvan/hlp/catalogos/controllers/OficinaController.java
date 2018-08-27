package corp.galvan.hlp.catalogos.controllers;

import corp.galvan.hlp.catalogos.domain.Oficina;
import corp.galvan.hlp.catalogos.model.OficinaModel;
import corp.galvan.hlp.catalogos.services.OficinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/oficina")
public class OficinaController {

    @Autowired
    private OficinaService _oficinaService;

    @RequestMapping(value = "/hlp/show", method = RequestMethod.GET)
    public OficinaModel getAllInhibidoresHLP()
    {
        OficinaModel _ObjectModel = new OficinaModel();
        List<Oficina> _listObjectModel= _oficinaService.listAll();
        _ObjectModel.setSuccess(true);
        if (_listObjectModel.isEmpty()) {
            _ObjectModel.setMessage("No existen registros");
        } else {
            _ObjectModel.setMessage("Se encontraron " + _listObjectModel.size() + " Oficina(s)");
        }
        _ObjectModel.setCode("200");
        _ObjectModel.setData(_listObjectModel);
        return _ObjectModel;
    }

}
