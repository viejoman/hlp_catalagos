package corp.galvan.hlp.catalogos.controllers;

import corp.galvan.hlp.catalogos.domain.Accion;
import corp.galvan.hlp.catalogos.services.AccionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accion")
public class AccionController {

    @Autowired
    private AccionService _accionService;

    Logger _log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public void setEstadoService(AccionService p__accionService) {
        this._accionService = p__accionService;
    }

    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public Accion addEstado(@RequestBody Accion p__accion) {
        _accionService.saveOrUpdate(p__accion);
        _log.debug("Added:: " + p__accion);
        return p__accion;
    }
}
