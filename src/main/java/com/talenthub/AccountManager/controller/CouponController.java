package com.talenthub.AccountManager.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/coupon")
public class CouponController {

//    @Autowired
//    private CouponService couponService;
//
//    @PostMapping
//    public String save(@Valid @RequestBody CouponVO vO) {
//        return couponService.save(vO).toString();
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete(@Valid @NotNull @PathVariable("id") Long id) {
//        couponService.delete(id);
//    }
//
//    @PutMapping("/{id}")
//    public void update(@Valid @NotNull @PathVariable("id") Long id,
//                       @Valid @RequestBody CouponUpdateVO vO) {
//        couponService.update(id, vO);
//    }
//
//    @GetMapping("/{id}")
//    public CouponDTO getById(@Valid @NotNull @PathVariable("id") Long id) {
//        return couponService.getById(id);
//    }
//
//    @GetMapping
//    public Page<CouponDTO> query(@Valid CouponQueryVO vO) {
//        return couponService.query(vO);
//    }
}
