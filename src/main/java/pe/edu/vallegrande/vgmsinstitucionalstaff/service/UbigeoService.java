package pe.edu.vallegrande.vgmsinstitucionalstaff.service;

import pe.edu.vallegrande.vgmsinstitucionalstaff.model.Ubigeo;
import reactor.core.publisher.Flux;

public interface UbigeoService {

    Flux<Ubigeo> getAll();

}
