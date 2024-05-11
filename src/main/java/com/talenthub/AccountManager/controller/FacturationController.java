package com.talenthub.AccountManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/facturation")
public class FacturationController {

//    @Autowired
//    private FacturationService facturationService;
//
//    @PostMapping
//    public String save(@Valid @RequestBody FacturationVO vO) {
//        return facturationService.save(vO).toString();
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
//        facturationService.delete(id);
//    }
//
//    @PutMapping("/{id}")
//    public void update(@Valid @NotNull @PathVariable("id") Integer id,
//                       @Valid @RequestBody FacturationUpdateVO vO) {
//        facturationService.update(id, vO);
//    }
//
//    @GetMapping("/{id}")
//    public FacturationDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
//        return facturationService.getById(id);
//    }
//
//    @GetMapping
//    public Page<FacturationDTO> query(@Valid FacturationQueryVO vO) {
//        return facturationService.query(vO);
//    }
}
