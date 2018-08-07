package corp.galvan.hlp.catalogos.controllers;

import corp.galvan.hlp.catalogos.domain.Estado;
import corp.galvan.hlp.catalogos.repositories.EstadoRepository;
import corp.galvan.hlp.catalogos.services.EstadoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/estado")
public class EstadoController {

    @Autowired
    private EstadoService _estadoService;

    Logger _log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public void setEstadoService(EstadoService p__estadoService) {
        this._estadoService = p__estadoService;
    }

    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public Estado addEstado(@RequestBody Estado p__estado) {
        _estadoService.saveOrUpdate(p__estado);
        _log.debug("Added:: " + p__estado);
        return p__estado;
    }

    @RequestMapping(value = "/edit",method = RequestMethod.PUT)
    public Long updateEstado(@RequestBody Estado p__estado) {
        Estado existEstado = _estadoService.getById(p__estado.getIdestado());
        if (existEstado == null) {
            _log.debug("Estado with id " + p__estado.getIdestado() + " does not exists");
            return 0L;
        } else {
            return p__estado.getIdestado();
        }
    }

    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public Long deleteInhibidor(@RequestBody Estado p__estado) {
        Estado existEstado = _estadoService.getById(p__estado.getIdestado());
        if (existEstado == null) {
            _log.debug("Estado with id " + p__estado.getIdestado() + " does not exists");
            return 0L;
        } else {
            _estadoService.delete(p__estado.getIdestado());
            return 1L;
        }
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public Long deleteInhibidor(@PathVariable("id") Long p__id) {
        Estado existEstado = _estadoService.getById(p__id);
        if (existEstado == null) {
            _log.debug("Estado with id " + p__id + " does not exists");
            return 0L;
        } else {
            _estadoService.delete(p__id);
            return 1L;
        }
    }

    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    public Estado getInhibidor(@PathVariable("id") Long p__id) {
        Estado _inhibidor = _estadoService.getById(p__id);
        if (_inhibidor == null) {
            _log.debug("Estado with id " + p__id + " does not exists");
            return new Estado();
        }
        _log.debug("Found Estado:: " + _inhibidor);
        return _inhibidor;
    }

    @RequestMapping(value = "/show",method = RequestMethod.GET)
    public List<Estado> getAllEstados() {
        List<Estado> _listEstados = _estadoService.listAll();
        if (_listEstados.isEmpty()) {
            _log.debug("Estados does not exists");

        }
        _log.debug("Se encontraron " + _listEstados.size() + " Estado(s)");
        _log.debug(Arrays.toString(_listEstados.toArray()));
        return _listEstados;
    }

}
