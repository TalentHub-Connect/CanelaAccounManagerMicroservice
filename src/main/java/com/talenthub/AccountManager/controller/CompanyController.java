package com.talenthub.AccountManager.controller;

import com.talenthub.AccountManager.model.Company;
import com.talenthub.AccountManager.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @CrossOrigin
    @PostMapping("/save")
    public Company sendMessage(@RequestBody Company company) {
        System.out.println(company.toString());
        return companyService.save(company);
    }


//
//    @PostMapping
//    public String save(@Valid @RequestBody CompanyVO vO) {
//        return companyService.save(vO).toString();
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
//        companyService.delete(id);
//    }
//
//    @PutMapping("/{id}")
//    public void update(@Valid @NotNull @PathVariable("id") Integer id,
//                       @Valid @RequestBody CompanyUpdateVO vO) {
//        companyService.update(id, vO);
//    }
//
//    @GetMapping("/{id}")
//    public CompanyDTO getById(@Valid @NotNull @PathVariable("id") Integer id) {
//        return companyService.getById(id);
//    }
//
//    @GetMapping
//    public Page<CompanyDTO> query(@Valid CompanyQueryVO vO) {
//        return companyService.query(vO);
//    }
}
