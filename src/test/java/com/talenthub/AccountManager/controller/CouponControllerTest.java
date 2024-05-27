package com.talenthub.AccountManager.controller;

import com.talenthub.AccountManager.model.Coupon;
import com.talenthub.AccountManager.service.CouponService;
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

@WebMvcTest(CouponController.class)
public class CouponControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CouponService couponService;

    @Test
    public void getAllCouponsTest() throws Exception {
        Mockito.when(couponService.findAllCoupons()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/coupon"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    public void createCouponTest() throws Exception {
        Coupon coupon = new Coupon();
        coupon.setId(1L);
        Mockito.when(couponService.saveCoupon(Mockito.any(Coupon.class))).thenReturn(coupon);

        mockMvc.perform(post("/coupon")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\": 1, \"name\": \"Test Coupon\"}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    public void getCouponByIdTest() throws Exception {
        Coupon coupon = new Coupon();
        coupon.setId(1L);
        Mockito.when(couponService.findById(1L)).thenReturn(Optional.of(coupon));

        mockMvc.perform(get("/coupon/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    public void updateCouponTest() throws Exception {
        Coupon coupon = new Coupon();
        coupon.setId(1L);
        Mockito.when(couponService.findById(1L)).thenReturn(Optional.of(coupon));
        Mockito.when(couponService.updateCoupon(Mockito.any(Long.class), Mockito.any(Coupon.class))).thenReturn(coupon);

        mockMvc.perform(put("/coupon/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"Updated Coupon\"}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    public void deleteCouponTest() throws Exception {
        mockMvc.perform(delete("/coupon/1"))
                .andExpect(status().isOk());
    }
}
