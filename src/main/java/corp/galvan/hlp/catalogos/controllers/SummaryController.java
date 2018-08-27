package corp.galvan.hlp.catalogos.controllers;

import corp.galvan.hlp.catalogos.domain.Summary;
import corp.galvan.hlp.catalogos.model.SummaryModel;
import corp.galvan.hlp.catalogos.services.EstadoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/summary")
public class SummaryController {

    @Autowired
    private EstadoService _estadoService;

    Logger _log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/show/",method = RequestMethod.GET)
    public SummaryModel getAllEstados(@RequestParam("idgrupo") long idgrupo, @RequestParam("idusuario") long idusuario) {

        SummaryModel _ObjectModel = new SummaryModel();
        List<Summary> _listObjectModel= _estadoService.getSummary(idgrupo, idusuario);
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
