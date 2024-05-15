package com.talenthub.AccountManager.repository;

import com.talenthub.AccountManager.model.Servicie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicieRepository extends JpaRepository<Servicie, Long> {
    @Query("SELECT s FROM Servicie s WHERE s.roleId = ?1")
    List<Servicie> findByRoleId(Long roleId);
}
