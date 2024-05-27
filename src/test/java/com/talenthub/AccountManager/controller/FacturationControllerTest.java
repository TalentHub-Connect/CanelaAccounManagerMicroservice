package com.talenthub.AccountManager.controller;

import com.talenthub.AccountManager.model.Facturation;
import com.talenthub.AccountManager.service.FacturationService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(FacturationController.class)
public class FacturationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FacturationService facturationService;

    @Test
    public void createFacturationTest() throws Exception {
        Facturation facturation = new Facturation();
        facturation.setId(1L);
        Mockito.when(facturationService.createFacturation(Mockito.any(Facturation.class))).thenReturn(facturation);

        mockMvc.perform(post("/facturation")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\": 1, \"name\": \"Test Facturation\"}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    public void getFacturationByIdTest() throws Exception {
        Facturation facturation = new Facturation();
        facturation.setId(1L);
        Mockito.when(facturationService.getFacturationById(1L)).thenReturn(Optional.of(facturation));

        mockMvc.perform(get("/facturation/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    public void updateFacturationTest() throws Exception {
        Facturation facturation = new Facturation();
        facturation.setId(1L);
        Mockito.when(facturationService.getFacturationById(1L)).thenReturn(Optional.of(facturation));
        Mockito.when(facturationService.updateFacturation(Mockito.any(Long.class), Mockito.any(Facturation.class))).thenReturn(facturation);

        mockMvc.perform(put("/facturation/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"Updated Facturation\"}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    public void deleteFacturationTest() throws Exception {
        mockMvc.perform(delete("/facturation/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void listAllFacturationsTest() throws Exception {
        Mockito.when(facturationService.listAllFacturations()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/facturation/list"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    public void getFacturationsByCompanyIdTest() throws Exception {
        Mockito.when(facturationService.getFacturationsByCompanyId(1L)).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/facturation/company/1"))
                .andExpect(status().isNotFound());
    }
}
