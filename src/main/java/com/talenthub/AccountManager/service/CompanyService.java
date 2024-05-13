package com.talenthub.AccountManager.service;

import com.talenthub.AccountManager.model.Company;
import com.talenthub.AccountManager.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    public Company save(Company company) {
        return companyRepository.save(company);
    }

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

//    public void delete(Integer id) {
//        companyRepository.deleteById(id);
//    }
//
//    public void update(Integer id, CompanyUpdateVO vO) {
//        Company bean = requireOne(id);
//        BeanUtils.copyProperties(vO, bean);
//        companyRepository.save(bean);
//    }
//
//    public CompanyDTO getById(Integer id) {
//        Company original = requireOne(id);
//        return toDTO(original);
//    }
//
//    public Page<CompanyDTO> query(CompanyQueryVO vO) {
//        throw new UnsupportedOperationException();
//    }
//
//    private CompanyDTO toDTO(Company original) {
//        CompanyDTO bean = new CompanyDTO();
//        BeanUtils.copyProperties(original, bean);
//        return bean;
//    }

//    private Company requireOne(Integer id) {
//        return companyRepository.findById(id)
//                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
//    }
}
