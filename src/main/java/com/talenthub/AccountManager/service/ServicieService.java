package com.talenthub.AccountManager.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.talenthub.AccountManager.model.Servicie;
import com.talenthub.AccountManager.repository.ServicieRepository;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ServicieService {

    private final ServicieRepository servicieRepository;

    @Autowired
    public ServicieService(ServicieRepository servicieRepository) {
        this.servicieRepository = servicieRepository;
    }

    @Transactional(readOnly = true)
    public List<Servicie> findAllServicies() {
        return servicieRepository.findAll();
    }

    @Transactional
    public Servicie createServicie(Servicie servicie) {
        return servicieRepository.save(servicie);
    }

    @Transactional
    public Servicie updateServicie(Long id, String description, Long roleId, String status) {
        Servicie servicie = servicieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Servicie not found"));
        servicie.setDescription(description);
        servicie.setRoleId(roleId);
        servicie.setStatus(status);
        return servicieRepository.save(servicie);
    }

    @Transactional(readOnly = true)
    public Optional<Servicie> findServicieById(Long id) {
        return servicieRepository.findById(id);
    }

    @Transactional
    public void deleteServicie(Long id) {
        Servicie servicie = servicieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Servicie not found"));
        servicieRepository.delete(servicie);
    }
}