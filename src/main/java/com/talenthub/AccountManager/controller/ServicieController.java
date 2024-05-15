package com.talenthub.AccountManager.controller;

import com.talenthub.AccountManager.model.ServiceEntity;
import com.talenthub.AccountManager.service.ServicieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Validated
@RestController
@RequestMapping("/services")
public class ServicieController {

    private final ServicieService servicieService;

    @Autowired
    public ServicieController(ServicieService servicieService) {
        this.servicieService = servicieService;
    }


    @GetMapping("/role/{rolId}")
    public ResponseEntity<List<ServiceEntity>> getServicesByRolId(@PathVariable Long rolId) {
        List<ServiceEntity> serviceEntities = servicieService.findServicesByRolId(rolId);
        return ResponseEntity.ok(serviceEntities);
    }

    // Crear un Servicio
    @PostMapping
    public ResponseEntity<ServiceEntity> createService(@RequestBody ServiceEntity serviceEntity) {
        ServiceEntity savedServiceEntity = servicieService.createServicie(serviceEntity);
        return ResponseEntity.status(201).body(savedServiceEntity);
    }

    // Obtener un Servicio por ID
    @GetMapping("/{serviceId}")
    public ResponseEntity<ServiceEntity> getService(@PathVariable Long serviceId) {
        ServiceEntity serviceEntity = servicieService.findServicieById(serviceId)
                .orElseThrow(() -> new RuntimeException("ServiceEntity not found with id: " + serviceId));
        return ResponseEntity.ok(serviceEntity);
    }

    // Actualizar un Servicio
    @PutMapping("/{serviceId}")
    public ResponseEntity<ServiceEntity> updateService(@PathVariable Long serviceId, @RequestBody ServiceEntity serviceEntityDetails) {
        ServiceEntity serviceEntity = servicieService.findServicieById(serviceId)
                .orElseThrow(() -> new RuntimeException("ServiceEntity not found with id: " + serviceId));

        serviceEntity.setDescription(serviceEntityDetails.getDescription());
        serviceEntity.setRolId(serviceEntityDetails.getRolId());
        serviceEntity.setStatus(serviceEntityDetails.getStatus());

        ServiceEntity updatedServiceEntity = servicieService.updateServicie(serviceId, serviceEntity.getDescription(), serviceEntity.getRolId(), serviceEntity.getStatus());
        return ResponseEntity.ok(updatedServiceEntity);
    }

    // Eliminar un Servicio
    @DeleteMapping("/{serviceId}")
    public ResponseEntity<Void> deleteService(@PathVariable Long serviceId) {
        servicieService.findServicieById(serviceId)
                .orElseThrow(() -> new RuntimeException("ServiceEntity not found with id: " + serviceId));

        servicieService.deleteServicie(serviceId);
        return ResponseEntity.ok().build();
    }
}
