package com.talenthub.AccountManager.repository;

import com.talenthub.AccountManager.model.Servicie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicieRepository extends JpaRepository<Servicie, Long> {
    List<Servicie> findByRoleId(Long roleId);
}
