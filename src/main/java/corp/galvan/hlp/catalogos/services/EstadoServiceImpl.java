package corp.galvan.hlp.catalogos.services;

import corp.galvan.hlp.catalogos.domain.Estado;
import corp.galvan.hlp.catalogos.repositories.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstadoServiceImpl implements EstadoService {

    private EstadoRepository _estadoRepository;

    @Autowired
    public EstadoServiceImpl(EstadoRepository p__accionRepository) {
        this._estadoRepository = p__accionRepository;
    }

    @Override
    public List<Estado> listAll() {
        List<Estado> _inhibidores = new ArrayList<>();
        _estadoRepository.findAll().forEach(_inhibidores::add);
        return _inhibidores;
    }

    @Override
    public Estado getById(Long id) {
        return _estadoRepository.findById(id).orElse(null);
    }

    @Override
    public Estado saveOrUpdate(Estado model) {
        _estadoRepository.save(model);
        return model;
    }

    @Override
    public void delete(Long id) {
        _estadoRepository.deleteById(id);

    }
}
