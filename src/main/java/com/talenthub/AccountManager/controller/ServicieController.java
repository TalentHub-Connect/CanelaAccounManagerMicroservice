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
    public List<Servicie> getAllServices(@RequestParam(required = false) Long roleId) {
        List<Servicie> services;
        if (roleId != null) {
            services = servicieService.findServiciesByRoleId(roleId);
        } else {
            services = servicieService.findAllServicies();
        }
        return services;
    }

    // Crear un Servicio
    @PostMapping
    public Servicie createService(@RequestBody Servicie service) {
        Servicie savedService = servicieService.createServicie(service);
        return savedService;
    }

    // Obtener un Servicio
    @GetMapping("/{serviceId}")
    public Servicie getService(@PathVariable Long serviceId) {
        try {
            Servicie service = servicieService.findServicieById(serviceId).get();
            return service;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    // Actualizar un Servicio
    @PutMapping("/{serviceId}")
    public Servicie updateService(@PathVariable Long serviceId, @RequestBody Servicie serviceDetails) {
        try{
            Servicie service = servicieService.findServicieById(serviceId).get();
            service.setDescription(serviceDetails.getDescription());
            service.setRoleId(serviceDetails.getRoleId());
            service.setStatus(serviceDetails.getStatus());

            Servicie updatedService = servicieService.updateServicie(serviceId, service.getDescription(), service.getRoleId(), service.getStatus());
            return updatedService;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    // Eliminar un Servicio
    @DeleteMapping("/{serviceId}")
    public boolean deleteService(@PathVariable Long serviceId) {
        try{
            Servicie service = servicieService.findServicieById(serviceId).get();
            servicieService.deleteServicie(serviceId);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
}
