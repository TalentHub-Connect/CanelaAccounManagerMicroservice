package com.talenthub.AccountManager.service;

import com.talenthub.AccountManager.model.ServiceEntity;
import com.talenthub.AccountManager.repository.ServicieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ServicieService {

    private final ServicieRepository servicieRepository;

    @Autowired
    public ServicieService(ServicieRepository servicieRepository) {
        this.servicieRepository = servicieRepository;
    }

    public List<ServiceEntity> findAllServicies() {
        return servicieRepository.findAll();
    }

    public List<ServiceEntity> findServicesByRolId(Long roleId) {
        return servicieRepository.findByRoleId(roleId);
    }

    @Transactional
    public ServiceEntity createServicie(ServiceEntity serviceEntity) {
        return servicieRepository.save(serviceEntity);
    }

    @Transactional
    public ServiceEntity updateServicie(Long id, String description, Long roleId, String status) {
        ServiceEntity serviceEntity = servicieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ServiceEntity not found"));
        serviceEntity.setDescription(description);
        serviceEntity.setRolId(roleId);
        serviceEntity.setStatus(status);
        return servicieRepository.save(serviceEntity);
    }

    @Transactional(readOnly = true)
    public Optional<ServiceEntity> findServicieById(Long id) {
        return servicieRepository.findById(id);
    }

    @Transactional
    public void deleteServicie(Long id) {
        ServiceEntity serviceEntity = servicieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ServiceEntity not found"));
        servicieRepository.delete(serviceEntity);
    }
}
