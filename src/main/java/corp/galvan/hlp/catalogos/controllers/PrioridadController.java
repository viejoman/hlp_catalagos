package corp.galvan.hlp.catalogos.controllers;

import corp.galvan.hlp.catalogos.domain.Prioridad;
import corp.galvan.hlp.catalogos.model.PrioridadModel;
import corp.galvan.hlp.catalogos.services.PrioridadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/prioridad")
public class PrioridadController {

    @Autowired
    private PrioridadService _prioridadService;

    @RequestMapping(value = "/hlp/show", method = RequestMethod.GET)
    public PrioridadModel getAllInhibidoresHLP()
    {
        PrioridadModel _ObjectModel = new PrioridadModel();
        List<Prioridad> _listObjectModel= _prioridadService.listAll();
        _ObjectModel.setSuccess(true);
        if (_listObjectModel.isEmpty()) {
            _ObjectModel.setMessage("No existen registros");
        } else {
            _ObjectModel.setMessage("Se encontraron " + _listObjectModel.size() + " Prioridad(es)");
        }
        _ObjectModel.setCode("200");
        _ObjectModel.setData(_listObjectModel);
        return _ObjectModel;
    }

}
