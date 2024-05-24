package com.talenthub.AccountManager.service;

import com.talenthub.AccountManager.model.Company;
import com.talenthub.AccountManager.model.Plan;
import com.talenthub.AccountManager.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanService {

    private final PlanRepository planRepository;

    @Autowired
    public PlanService(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    @Autowired
    CompanyService companyService;

    public List<Plan> findAllPlans() {
        return planRepository.findAll();
    }

    public Plan findPlanById(Long id) {
        return planRepository.findById(id).orElse(null);
    }
    

    public Plan savePlan(Plan plan) {
        return planRepository.save(plan);
    }

    public Plan updatePlan(Long id, Plan newPlan) {
        return planRepository.findById(id)
            .map(plan -> {
                plan.setName(newPlan.getName());
                plan.setDescription(newPlan.getDescription());
                plan.setMaxnumworkers(newPlan.getMaxnumworkers());
                plan.setPrice(newPlan.getPrice());
                plan.setDuration(newPlan.getDuration());
                plan.setStatus(newPlan.getStatus());
                return planRepository.save(plan);
            })
            .orElseGet(() -> {
                newPlan.setId(id);
                return planRepository.save(newPlan);
            });
    }

    public void deletePlan(Long id) {
        planRepository.deleteById(id);
    }

    public Optional<Plan> findById(Long id) {
        return planRepository.findById(id);
    }

    public Plan findPlanByCompanyId(Integer companyid) {
        try{
            Company company = companyService.findById(companyid);
            return planRepository.findById(company.getPlanId()).get();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
