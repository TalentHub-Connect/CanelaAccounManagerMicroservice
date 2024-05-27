package com.talenthub.AccountManager.controller;

import com.talenthub.AccountManager.model.Plan;
import com.talenthub.AccountManager.service.PlanService;
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

@WebMvcTest(PlanController.class)
public class PlanControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlanService planService;

    @Test
    public void getAllPlansTest() throws Exception {
        Mockito.when(planService.findAllPlans()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/plan/list"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    public void getPlanByIdTest() throws Exception {
        Plan plan = new Plan();
        plan.setId(1L);
        Mockito.when(planService.findPlanById(1L)).thenReturn(plan);

        mockMvc.perform(get("/plan/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    public void addPlanTest() throws Exception {
        Plan plan = new Plan();
        plan.setId(1L);
        Mockito.when(planService.savePlan(Mockito.any(Plan.class))).thenReturn(plan);

        mockMvc.perform(post("/plan")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\": 1, \"name\": \"Test Plan\"}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    public void updatePlanTest() throws Exception {
        Plan plan = new Plan();
        plan.setId(1L);
        Mockito.when(planService.findPlanById(1L)).thenReturn(plan);
        Mockito.when(planService.updatePlan(Mockito.any(Long.class), Mockito.any(Plan.class))).thenReturn(plan);

        mockMvc.perform(put("/plan/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"Updated Plan\"}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    public void deletePlanTest() throws Exception {
        mockMvc.perform(delete("/plan/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void getPlanByCompanyIdTest() throws Exception {
        Plan plan = new Plan();
        plan.setId(1L);
        Mockito.when(planService.findPlanByCompanyId(1)).thenReturn(plan);

        mockMvc.perform(get("/plan/company/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1));
    }
}
