package corp.galvan.hlp.catalogos.services;

import corp.galvan.hlp.catalogos.domain.TipoServicio;
import corp.galvan.hlp.catalogos.repositories.TipoServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TipoServiceImpl implements TipoService {

    private TipoServicioRepository _tipoServicioRepository;

    @Autowired
    public TipoServiceImpl(TipoServicioRepository p__subCategoriaRepository) {
        this._tipoServicioRepository = p__subCategoriaRepository;
    }

    @Override
    public List<TipoServicio> listAll() {
        List<TipoServicio> _inhibidores = new ArrayList<>();
        _tipoServicioRepository.findAll().forEach(_inhibidores::add);
        return _inhibidores;
    }

    @Override
    public TipoServicio getById(Long id) {
        return _tipoServicioRepository.findById(id).orElse(null);
    }

    @Override
    public TipoServicio saveOrUpdate(TipoServicio model) {
        _tipoServicioRepository.save(model);
        return model;
    }

    @Override
    public void delete(Long id) {
        _tipoServicioRepository.deleteById(id);

    }

}
