package com.talenthub.AccountManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.talenthub.AccountManager.model.Facturation;
import com.talenthub.AccountManager.service.FacturationService;

@Validated
@RestController
@RequestMapping("/facturation")
public class FacturationController {

    @Autowired
    private FacturationService service;

    @PostMapping
    public Facturation createFacturation(@RequestBody Facturation facturation) {
        return service.createFacturation(facturation);
    }

    @GetMapping("/{facturationId}")
    public Facturation getFacturation(@PathVariable Long facturationId) {
        try {
            return service.getFacturationById(facturationId).get();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PutMapping("/{facturationId}")
    public Facturation updateFacturation(@PathVariable Long facturationId, @RequestBody Facturation facturation) {
        return service.updateFacturation(facturationId, facturation);
    }

    @DeleteMapping("/{facturationId}")
    public boolean deleteFacturation(@PathVariable Long facturationId) {
        try {
            service.deleteFacturation(facturationId);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @GetMapping("/list")
    public List<Facturation> listAllFacturations() {
        return service.listAllFacturations();
    }
}
