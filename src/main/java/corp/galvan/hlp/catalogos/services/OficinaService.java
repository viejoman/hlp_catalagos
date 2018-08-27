package corp.galvan.hlp.catalogos.services;

import corp.galvan.hlp.catalogos.domain.Oficina;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/oficina")
public interface OficinaService {

    List<Oficina> listAll();

    Oficina getById(Long id);

    Oficina saveOrUpdate(Oficina model);

    void delete(Long id);

}
