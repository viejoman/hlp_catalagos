package corp.galvan.hlp.catalogos.controllers;


import corp.galvan.hlp.catalogos.domain.Inhibidor;
import corp.galvan.hlp.catalogos.model.InhibidorModel;
import corp.galvan.hlp.catalogos.repositories.InhibidorRepository;
import corp.galvan.hlp.catalogos.services.InhibidorService;
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
@RequestMapping("/inhibidor")
public class InhibidorController {

    @Autowired
    private InhibidorService _inhibidorService;

    Logger _log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public void setInhibidorService(InhibidorService p__inhibidorService) {
        this._inhibidorService = p__inhibidorService;
    }

    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public Inhibidor addInhibidor(@RequestBody Inhibidor p__inhibidor) {
        _inhibidorService.saveOrUpdate(p__inhibidor);
        _log.debug("Added:: " + p__inhibidor);
        return p__inhibidor;
    }

    @RequestMapping(value = "/edit",method = RequestMethod.PUT)
    public Long updateInhibidor(@RequestBody Inhibidor p__inhibidor) {
        Inhibidor existInhibidor = _inhibidorService.getById(p__inhibidor.getIdinhibidor());
        if (existInhibidor == null) {
            _log.debug("Inhibidor with id " + p__inhibidor.getIdinhibidor() + " does not exists");
            return 0L;
        } else {
            _inhibidorService.saveOrUpdate(p__inhibidor);
            return p__inhibidor.getIdinhibidor();
        }
    }

    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public Long deleteInhibidor(@RequestBody Inhibidor p__inhibidor) {
        Inhibidor existInhibidor = _inhibidorService.getById(p__inhibidor.getIdinhibidor());
        if (existInhibidor == null) {
            _log.debug("Inhibidor with id " + p__inhibidor.getIdinhibidor() + " does not exists");
            return 0L;
        } else {
            _inhibidorService.delete(p__inhibidor.getIdinhibidor());
            return 1L;
        }
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public Long deleteInhibidor(@PathVariable("id") Long p__id) {
        Inhibidor existInhibidor = _inhibidorService.getById(p__id);
        if (existInhibidor == null) {
            _log.debug("Inhibidor with id " + p__id + " does not exists");
            return 0L;
        } else {
            _inhibidorService.delete(p__id);
            return 1L;
        }
    }

    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    public Inhibidor getInhibidor(@PathVariable("id") Long p__id) {
        Inhibidor _inhibidor = _inhibidorService.getById(p__id);
        if (_inhibidor == null) {
            _log.debug("Inhibidor with id " + p__id + " does not exists");
            return new Inhibidor();
        }
        _log.debug("Found Inhibidor:: " + _inhibidor);
        return _inhibidor;
    }

    @RequestMapping(value = "/show",method = RequestMethod.GET)
    public List<Inhibidor> getAllInhibidores() {
        List<Inhibidor> _listinhibidor = _inhibidorService.listAll();
        if (_listinhibidor.isEmpty()) {
            _log.debug("Inhibidor does not exists");

        }
        _log.debug("Se encontraron " + _listinhibidor.size() + " Inhibidor(res)");
        _log.debug(Arrays.toString(_listinhibidor.toArray()));
        return _listinhibidor;
    }

    @RequestMapping(value = "/hlp/show", method = RequestMethod.GET)
    public InhibidorModel getAllInhibidoresHLP()
    {
        InhibidorModel _InhibidorModel = new InhibidorModel();
        List<Inhibidor> _listinhibidor = _inhibidorService.listAll();
        _InhibidorModel.setSuccess(true);
        if (_listinhibidor.isEmpty()) {
            _InhibidorModel.setMessage("No hay registros de inhibidores");
        } else {
            _InhibidorModel.setMessage("Se encontraron " + _listinhibidor.size() + " Inhibidor(res)");
        }
        _InhibidorModel.setCode("200");
        _InhibidorModel.setData(_listinhibidor);
        return _InhibidorModel;
    }
}
