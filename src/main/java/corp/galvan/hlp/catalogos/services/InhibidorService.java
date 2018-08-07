package corp.galvan.hlp.catalogos.services;

import corp.galvan.hlp.catalogos.domain.Inhibidor;
import java.util.List;

public interface InhibidorService {

    List<Inhibidor> listAll();

    Inhibidor getById(Long id);

    Inhibidor saveOrUpdate(Inhibidor model);

    void delete(Long id);

}
