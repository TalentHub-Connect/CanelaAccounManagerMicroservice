package com.talenthub.AccountManager.controller;


import com.talenthub.AccountManager.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.talenthub.AccountManager.model.Plan;
import com.talenthub.AccountManager.service.PlanService;

import java.util.List;

@RestController
@RequestMapping("/plan")
public class PlanController {

    @Autowired
    private PlanService planService;

    @GetMapping("/list")
    public List<Plan> getAllPlans() {
        return planService.findAllPlans();
    }

   /*  @GetMapping("/list")
    public List<Plan> findAll() {
        return planService.findAllPlans();
    }*/


    @GetMapping("/{id}")
public ResponseEntity<Plan> getPlanById(@PathVariable Long id) {
    Plan plan = planService.findPlanById(id);
    if (plan != null) {
        return ResponseEntity.ok(plan);
    } else {
        return ResponseEntity.notFound().build();
    }
    }

    @PostMapping
    public Plan addPlan(@RequestBody Plan plan) {
        return planService.savePlan(plan);
    }

    @PutMapping("/{id}")
    public Plan updatePlan(@PathVariable Long id, @RequestBody Plan planDetails) {
        return (planService.updatePlan(id, planDetails));
    }

    @DeleteMapping("/{id}")
    public boolean deletePlan(@PathVariable Long id) {
        planService.deletePlan(id);
        return true;
    }

    @GetMapping("/company/{companyid}")
    public ResponseEntity<Plan> getPlanByCompanyId(@PathVariable Integer companyid) {
        Plan plan = planService.findPlanByCompanyId(companyid);
        if (plan != null) {
            return ResponseEntity.ok(plan);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
