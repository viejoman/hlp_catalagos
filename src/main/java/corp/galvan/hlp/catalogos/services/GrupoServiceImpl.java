package corp.galvan.hlp.catalogos.services;

import corp.galvan.hlp.catalogos.domain.Grupo;
import corp.galvan.hlp.catalogos.repositories.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GrupoServiceImpl implements GrupoService {

    private GrupoRepository _Repository;

    @Autowired
    public GrupoServiceImpl(GrupoRepository p__oficinaRepository) {
        this._Repository = p__oficinaRepository;
    }

    @Override
    public List<Grupo> listAll() {
        List<Grupo> _listAux = new ArrayList<>();
        _Repository.findAll().forEach(_listAux::add);
        return _listAux;
    }

    @Override
    public Grupo getById(Long id) {
        return _Repository.findById(id).orElse(null);
    }

    @Override
    public Grupo saveOrUpdate(Grupo model) {
        _Repository.save(model);
        return model;
    }

    @Override
    public void delete(Long id) {
        _Repository.deleteById(id);

    }

}
