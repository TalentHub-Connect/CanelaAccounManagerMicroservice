package com.talenthub.AccountManager.service;

import com.talenthub.AccountManager.model.Plan;
import com.talenthub.AccountManager.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanService {

    @Autowired
    PlanRepository planRepository;
    public List<Plan> findAll() {
        return planRepository.findAll();
    }
}
