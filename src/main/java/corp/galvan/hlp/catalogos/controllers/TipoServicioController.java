package corp.galvan.hlp.catalogos.controllers;

import corp.galvan.hlp.catalogos.domain.TipoServicio;
import corp.galvan.hlp.catalogos.model.TipoServicioModel;
import corp.galvan.hlp.catalogos.services.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tiposervicio")
public class TipoServicioController {

    @Autowired
    private TipoService _tipoService;

    @RequestMapping(value = "/hlp/show", method = RequestMethod.GET)
    public TipoServicioModel getAllInhibidoresHLP()
    {
        TipoServicioModel _ObjectModel = new TipoServicioModel();
        List<TipoServicio> _listObjectModel= _tipoService.listAll();
        _ObjectModel.setSuccess(true);
        if (_listObjectModel.isEmpty()) {
            _ObjectModel.setMessage("No existen registros");
        } else {
            _ObjectModel.setMessage("Se encontraron " + _listObjectModel.size() + " registro(s)");
        }
        _ObjectModel.setCode("200");
        _ObjectModel.setData(_listObjectModel);
        return _ObjectModel;
    }

}
