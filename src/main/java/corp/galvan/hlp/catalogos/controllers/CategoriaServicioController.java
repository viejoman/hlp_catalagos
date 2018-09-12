package corp.galvan.hlp.catalogos.controllers;

import corp.galvan.hlp.catalogos.domain.CategoriaServicio;
import corp.galvan.hlp.catalogos.domain.SubCategoriaServicio;
import corp.galvan.hlp.catalogos.model.CatergoriaServicioModel;
import corp.galvan.hlp.catalogos.services.CategoriaService;
import corp.galvan.hlp.catalogos.services.SubCategoriaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catserv")
public class CategoriaServicioController {

    @Autowired
    private CategoriaService _categoriaService;

    @Autowired
    private SubCategoriaService _subcategoriaService;

    Logger _log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/show",method = RequestMethod.GET)
    public List<CategoriaServicio> getAllCategoriaServicios() {
        List<CategoriaServicio> _listCategorias = _categoriaService.listAll();
        if (_listCategorias.isEmpty()) {
            _log.debug("Categoria does not exists");

        }
        _log.debug("Se encontraron " + _listCategorias.size() + " Categoria(s)");
        _log.debug(Arrays.toString(_listCategorias.toArray()));
        return _listCategorias;
    }

    @RequestMapping(value = "/hlp/show/", method = RequestMethod.GET)
    public CatergoriaServicioModel getAllCategoriaServicioHLP(@RequestParam(value = "idtipocat", required = false) Integer p__idtipocat)
    {
        Long _idTipoCatAux = null;

        CatergoriaServicioModel _CategoriaServModel = new CatergoriaServicioModel();
        //List<CategoriaServicio> _listCategoriaServ = _categoriaService.listAll();
        List<CategoriaServicio> _listCategoriaServ = _categoriaService.getCategoriaServicioByOpcion(1L);
        _CategoriaServModel.setSuccess(true);
        if (_listCategoriaServ.isEmpty()) {
            _CategoriaServModel.setMessage("No hay registros de categorias");
        } else {

            if (p__idtipocat != null) {
                _idTipoCatAux = new Long(p__idtipocat);
                _listCategoriaServ = this.getFilterOutput(_listCategoriaServ, _idTipoCatAux);
            }

            _CategoriaServModel.setMessage("Se encontraron " + _listCategoriaServ.size() + " Categoria(s)");
            for (CategoriaServicio _categoriaAux : _listCategoriaServ) {
                List<SubCategoriaServicio> _listSubCategoria = _subcategoriaService.getSubCategoriaByIdCategoria(_categoriaAux.getIdcategoriaserv());
                _categoriaAux.setSubcategoriasservicio(_listSubCategoria);
            }
        }
        _CategoriaServModel.setCode("200");
        _CategoriaServModel.setData(_listCategoriaServ);
        return _CategoriaServModel;

    }

    private static List<CategoriaServicio> getFilterOutput(List<CategoriaServicio> p__items, Long p__filter) {

        return p__items.stream().filter(p -> p__filter.equals(p.getIdtipocat())).collect(Collectors.toList());

    }

}
