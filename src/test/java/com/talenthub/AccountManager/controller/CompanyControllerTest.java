package com.talenthub.AccountManager.controller;

import com.talenthub.AccountManager.model.Company;
import com.talenthub.AccountManager.payload.response.CompanyResponse;
import com.talenthub.AccountManager.service.CompanyService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CompanyController.class)
public class CompanyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CompanyService companyService;

    @Test
    public void saveCompanyTest() throws Exception {
        Company company = new Company();
        company.setId(1);
        Mockito.when(companyService.save(Mockito.any(Company.class))).thenReturn(company);

        mockMvc.perform(post("/api/talentsoft/company/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\": 1, \"name\": \"Test Company\"}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    public void findAllCompaniesTest() throws Exception {
        Mockito.when(companyService.findAll()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/talentsoft/company/list"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    public void getCompanyByIdTest() throws Exception {
        Company company = new Company();
        company.setId(1);
        Mockito.when(companyService.findById(1)).thenReturn(company);

        mockMvc.perform(get("/api/talentsoft/company/id/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1));
    }
    
    @Test
    public void getCompanyByEmailTest() throws Exception {
        CompanyResponse response = new CompanyResponse(0);
        response.setId(1);
        Mockito.when(companyService.getCompanyId("test@example.com")).thenReturn(response);

        mockMvc.perform(get("/api/talentsoft/company/test@example.com"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1));
    }
}
