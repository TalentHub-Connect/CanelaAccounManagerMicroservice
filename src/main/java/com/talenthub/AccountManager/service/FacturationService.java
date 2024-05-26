package com.talenthub.AccountManager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talenthub.AccountManager.model.Facturation;
import com.talenthub.AccountManager.repository.FacturationRepository;

import jakarta.transaction.Transactional;

@Service
public class FacturationService {

    private final FacturationRepository repository;

    @Autowired
    public FacturationService(FacturationRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Facturation createFacturation(Facturation facturation) {
        return repository.save(facturation);
    }

    @Transactional
    public Optional<Facturation> getFacturationById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Facturation updateFacturation(Long id, Facturation updatedFacturation) {
        return repository.findById(id).map(facturation -> {
            facturation.setFacturationDate(updatedFacturation.getFacturationDate());
            facturation.setPrice(updatedFacturation.getPrice());
            facturation.setStatus(updatedFacturation.getStatus());
            facturation.setCompanyId(updatedFacturation.getCompanyId());
            facturation.setName(updatedFacturation.getName());
            return repository.save(facturation);
        }).orElseThrow(() -> new RuntimeException("Facturation not found"));
    }

    @Transactional
    public void deleteFacturation(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public List<Facturation> listAllFacturations() {
        return repository.findAll();
    }

        // Nuevo método para obtener facturación por ID de empresa
    public List<Facturation> getFacturationsByCompanyId(Long companyId) {
            return repository.findByCompanyId(companyId);
    }
}