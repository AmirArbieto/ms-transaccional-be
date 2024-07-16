package pe.edu.vallegrande.vgmsinstitucionalstaff.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.vgmsinstitucionalstaff.model.InstitucionalStaff;
import pe.edu.vallegrande.vgmsinstitucionalstaff.service.InstitucionalStaffService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/institucional-staff")
@RequiredArgsConstructor
public class InstitucionalStaffController {

    private final InstitucionalStaffService institucionalStaffService;

    @PostMapping("/create")
    public Mono<InstitucionalStaff> create(@RequestBody InstitucionalStaff institucionalStaff) {
        return institucionalStaffService.create(institucionalStaff);
    }

    @PutMapping("/update/{id}")
    public Mono<InstitucionalStaff> update(@PathVariable String id , @RequestBody InstitucionalStaff institucionalStaff) {
        return institucionalStaffService.update(id, institucionalStaff);
    }

    @PutMapping("/activate/{id}")
    public Mono<InstitucionalStaff> activate(@PathVariable String id) {
        return institucionalStaffService.activate(id);
    }

    @PutMapping("/deactivate/{id}")
    public Mono<InstitucionalStaff> deactivate(@PathVariable String id) {
        return institucionalStaffService.deactivate(id);
    }

    @GetMapping("/get/{id}")
    public Mono<InstitucionalStaff> getById(@PathVariable String id) {
        return institucionalStaffService.getById(id);
    }

    @GetMapping("/list")
    public Flux<InstitucionalStaff> getAll() {
        return institucionalStaffService.getAll();
    }

    @GetMapping("/list/active")
    public Mono<Page<InstitucionalStaff>> getAllActive(Pageable pageable) {
        return institucionalStaffService.getAllActive(pageable);
    }

    @GetMapping("/list/inactive")
    public Flux<InstitucionalStaff> getAllInactive() {
        return institucionalStaffService.getAllInactive();
    }
}
