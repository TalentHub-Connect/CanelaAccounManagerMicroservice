package com.talenthub.AccountManager.controller;

import com.talenthub.AccountManager.model.Company;
import com.talenthub.AccountManager.payload.response.CompanyResponse;
import com.talenthub.AccountManager.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/talentsoft/company")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @CrossOrigin
    @PostMapping("/save")
    public Company sendMessage(@RequestBody Company company) {
        System.out.println(company.toString());
        return companyService.save(company);
    }

    @CrossOrigin
    @GetMapping("/list")
    public List<Company> findAll() {
        return companyService.findAll();
    }

    @GetMapping("/{email}")
    public ResponseEntity<CompanyResponse> getCompanyId(@PathVariable String email) {
        try {
            return ResponseEntity.ok(companyService.getCompanyId(email));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


    @GetMapping("id/{companyid}")
    public ResponseEntity<Company> getCompanyById(@PathVariable String companyid) {
        try {
            return ResponseEntity.ok(companyService.findById(Integer.parseInt(companyid)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
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
