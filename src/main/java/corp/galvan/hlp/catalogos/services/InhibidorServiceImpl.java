package corp.galvan.hlp.catalogos.services;

import corp.galvan.hlp.catalogos.domain.Inhibidor;
import corp.galvan.hlp.catalogos.repositories.InhibidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InhibidorServiceImpl implements InhibidorService {

    private InhibidorRepository _inhibidorRepository;


    @Autowired
    public InhibidorServiceImpl(InhibidorRepository p__inhibidorRepository) {
        this._inhibidorRepository = p__inhibidorRepository;
    }


    @Override
    public List<Inhibidor> listAll() {
        List<Inhibidor> _inhibidores = new ArrayList<>();
        _inhibidorRepository.findAll().forEach(_inhibidores::add);
        return _inhibidores;
    }

    @Override
    public Inhibidor getById(Long id) {
        return _inhibidorRepository.findById(id).orElse(null);
    }

    @Override
    public Inhibidor saveOrUpdate(Inhibidor model) {
        _inhibidorRepository.save(model);
        return model;
    }

    @Override
    public void delete(Long id) {
        _inhibidorRepository.deleteById(id);

    }
}
