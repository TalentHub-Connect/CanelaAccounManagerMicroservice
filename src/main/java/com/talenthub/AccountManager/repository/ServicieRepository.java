package com.talenthub.AccountManager.repository;

import com.talenthub.AccountManager.model.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicieRepository extends JpaRepository<ServiceEntity, Long> {
    @Query("SELECT s FROM ServiceEntity s WHERE s.rolId = ?1")
    List<ServiceEntity> findByRoleId(Long roleId);
}
