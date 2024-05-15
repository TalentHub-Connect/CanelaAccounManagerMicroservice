package com.talenthub.AccountManager.controller;

import com.talenthub.AccountManager.model.Servicie;
import com.talenthub.AccountManager.service.ServicieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/services")
public class ServicieController {

    @Autowired
    private ServicieService servicieService;

    // Listar todos los Servicios o filtrar por rol_id
    @GetMapping
    public ResponseEntity<List<Servicie>> getAllServices(@RequestParam(required = false) Long roleId) {
        List<Servicie> services;
        if (roleId != null) {
            services = servicieService.findServiciesByRoleId(roleId);
        } else {
            services = servicieService.findAllServicies();
        }
        return ResponseEntity.ok(services);
    }

    // Crear un Servicio
    @PostMapping
    public ResponseEntity<Servicie> createService(@RequestBody Servicie service) {
        Servicie savedService = servicieService.createServicie(service);
        return ResponseEntity.status(201).body(savedService);
    }

    // Obtener un Servicio
    @GetMapping("/{serviceId}")
    public ResponseEntity<Servicie> getService(@PathVariable Long serviceId) {
        Servicie service = servicieService.findServicieById(serviceId)
            .orElseThrow(() -> new RuntimeException("Service not found with id: " + serviceId));
        return ResponseEntity.ok(service);
    }

    // Actualizar un Servicio
    @PutMapping("/{serviceId}")
    public ResponseEntity<Servicie> updateService(@PathVariable Long serviceId, @RequestBody Servicie serviceDetails) {
        Servicie service = servicieService.findServicieById(serviceId)
            .orElseThrow(() -> new RuntimeException("Service not found with id: " + serviceId));

        service.setDescription(serviceDetails.getDescription());
        service.setRoleId(serviceDetails.getRoleId());
        service.setStatus(serviceDetails.getStatus());

        Servicie updatedService = servicieService.updateServicie(serviceId, service.getDescription(), service.getRoleId(), service.getStatus());
        return ResponseEntity.ok(updatedService);
    }

    // Eliminar un Servicio
    @DeleteMapping("/{serviceId}")
    public ResponseEntity<Void> deleteService(@PathVariable Long serviceId) {
        Servicie service = servicieService.findServicieById(serviceId)
            .orElseThrow(() -> new RuntimeException("Service not found with id: " + serviceId));

        servicieService.deleteServicie(serviceId);
        return ResponseEntity.ok().build();
    }
}
