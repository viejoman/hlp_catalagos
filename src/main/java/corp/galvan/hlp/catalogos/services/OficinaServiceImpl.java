package corp.galvan.hlp.catalogos.services;

import corp.galvan.hlp.catalogos.domain.Oficina;
import corp.galvan.hlp.catalogos.repositories.OficinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OficinaServiceImpl implements OficinaService {

    private OficinaRepository _oficinaRepository;

    @Autowired
    public OficinaServiceImpl(OficinaRepository p__oficinaRepository) {
        this._oficinaRepository = p__oficinaRepository;
    }

    @Override
    public List<Oficina> listAll() {
        List<Oficina> _listAux = new ArrayList<>();
        _oficinaRepository.findAll().forEach(_listAux::add);
        return _listAux;
    }

    @Override
    public Oficina getById(Long id) {
        return _oficinaRepository.findById(id).orElse(null);
    }

    @Override
    public Oficina saveOrUpdate(Oficina model) {
        _oficinaRepository.save(model);
        return model;
    }

    @Override
    public void delete(Long id) {
        _oficinaRepository.deleteById(id);

    }

}
