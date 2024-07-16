package pe.edu.vallegrande.vgmsinstitucionalstaff.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.vgmsinstitucionalstaff.model.Ubigeo;
import pe.edu.vallegrande.vgmsinstitucionalstaff.service.UbigeoService;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/ubigeo")
@RequiredArgsConstructor
public class UbigeoController {

    private final UbigeoService ubigeoService;
    
    @GetMapping("/list")
    public Flux<Ubigeo> getAll() {
        return ubigeoService.getAll();
    }

}
