package corp.galvan.hlp.catalogos.controllers;

import corp.galvan.hlp.catalogos.domain.CategoriaServicio;
import corp.galvan.hlp.catalogos.domain.ConfigRutina;
import corp.galvan.hlp.catalogos.domain.SubCategoriaServicio;
import corp.galvan.hlp.catalogos.model.CatergoriaServicioModel;
import corp.galvan.hlp.catalogos.model.ConfigRutinaModel;
import corp.galvan.hlp.catalogos.services.CategoriaService;
import corp.galvan.hlp.catalogos.services.SubCategoriaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rutina")
public class RutinaController {

    @Autowired
    private CategoriaService _categoriaService;

    @Autowired
    private SubCategoriaService _subcategoriaService;

    Logger _log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/hlp/show", method = RequestMethod.GET)
    public CatergoriaServicioModel getAllRutinasHLP()
    {
        CatergoriaServicioModel _CategoriaServModel = new CatergoriaServicioModel();
        //List<CategoriaServicio> _listCategoriaServ = _categoriaService.listAll();
        List<CategoriaServicio> _listCategoriaServ = _categoriaService.getCategoriaServicioByOpcion(2L);
        _CategoriaServModel.setSuccess(true);
        if (_listCategoriaServ.isEmpty()) {
            _CategoriaServModel.setMessage("No hay registros de rutinas");
        } else {
            _CategoriaServModel.setMessage("Se encontraron " + _listCategoriaServ.size() + " Rutina(s)");
            for (CategoriaServicio _categoriaAux : _listCategoriaServ) {
                List<SubCategoriaServicio> _listSubCategoria = _subcategoriaService.getSubCategoriaByIdCategoria(_categoriaAux.getIdcategoriaserv());
                _categoriaAux.setSubcategoriasservicio(_listSubCategoria);
            }
        }
        _CategoriaServModel.setCode("200");
        _CategoriaServModel.setData(_listCategoriaServ);
        return _CategoriaServModel;
    }

    @RequestMapping(value = "/hlp/config", method = RequestMethod.GET)
    public ConfigRutinaModel getConfiguracionRutinaHLP(@RequestParam("oficina") long oficina)
    {
        ConfigRutinaModel _auxModel = new ConfigRutinaModel();
        List<ConfigRutina> _listAux = _categoriaService.getCofiguracionRutina(oficina);
        _auxModel.setSuccess(true);
        if (_listAux.isEmpty()) {
            _auxModel.setMessage("No hay registros de rutinas");
        }
        _auxModel.setCode("200");
        _auxModel.setData(_listAux);
        return _auxModel;
    }
}
