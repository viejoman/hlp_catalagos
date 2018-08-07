package corp.galvan.hlp.catalogos.controllers;

import corp.galvan.hlp.catalogos.domain.SubCategoriaServicio;
import corp.galvan.hlp.catalogos.model.SubCateoriaServicioModel;
import corp.galvan.hlp.catalogos.services.SubCategoriaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/subcatserv")
public class SubCategoriaServicioController {

    @Autowired
    private SubCategoriaService _subcategoriaService;

    Logger _log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/show",method = RequestMethod.GET)
    public List<SubCategoriaServicio> getAllSubCategoriaServicios() {
        List<SubCategoriaServicio> _listSubCategorias = _subcategoriaService.listAll();
        if (_listSubCategorias.isEmpty()) {
            _log.debug("SubCategoria does not exists");

        }
        _log.debug("Se encontraron " + _listSubCategorias.size() + " SubCategoria(s)");
        _log.debug(Arrays.toString(_listSubCategorias.toArray()));
        return _listSubCategorias;
    }

    @RequestMapping(value = "/hlp/show", method = RequestMethod.GET)
    public SubCateoriaServicioModel getAllInhibidoresHLP()
    {
        SubCateoriaServicioModel _SubCategoriaServModel = new SubCateoriaServicioModel();
        List<SubCategoriaServicio> _listSubCategoriaServ = _subcategoriaService.listAll();
        _SubCategoriaServModel.setSuccess(true);
        if (_listSubCategoriaServ.isEmpty()) {
            _SubCategoriaServModel.setMessage("No hay registros de subcategorias");
        } else {
            _SubCategoriaServModel.setMessage("Se encontraron " + _listSubCategoriaServ.size() + " SubCategoria(s)");
        }
        _SubCategoriaServModel.setCode("200");
        _SubCategoriaServModel.setData(_listSubCategoriaServ);
        return _SubCategoriaServModel;
    }

    @RequestMapping(value = "/hlp/show/{id}", method = RequestMethod.GET)
    public SubCateoriaServicioModel getAllSubCategoriaSrvByIdCategoria(@PathVariable("id") Long p__id) {
        SubCateoriaServicioModel _SubCategoriaServModel = new SubCateoriaServicioModel();
        List<SubCategoriaServicio> _listSubCategoriaServ = _subcategoriaService.getSubCategoriaByIdCategoria(p__id);
        _SubCategoriaServModel.setSuccess(true);
        if (_listSubCategoriaServ.isEmpty()) {
            _SubCategoriaServModel.setMessage("No hay registros de subcategorias");
        } else {
            _SubCategoriaServModel.setMessage("Se encontraron " + _listSubCategoriaServ.size() + " SubCategoria(s)");
        }
        _SubCategoriaServModel.setCode("200");
        _SubCategoriaServModel.setData(_listSubCategoriaServ);
        return _SubCategoriaServModel;
    }

}
