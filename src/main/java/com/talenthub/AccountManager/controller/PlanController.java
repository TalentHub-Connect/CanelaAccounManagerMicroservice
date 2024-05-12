package com.talenthub.AccountManager.controller;


import com.talenthub.AccountManager.model.Plan;
import com.talenthub.AccountManager.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/plan")
public class PlanController {

    @Autowired
    private PlanService planService;

    @CrossOrigin
    @GetMapping("/list")
    List<Plan> findAll(){
        return planService.findAll();
    }
}