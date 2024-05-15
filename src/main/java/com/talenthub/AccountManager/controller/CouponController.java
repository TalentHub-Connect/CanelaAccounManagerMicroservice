package com.talenthub.AccountManager.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.talenthub.AccountManager.model.Coupon;
import com.talenthub.AccountManager.service.CouponService;

import java.util.List;

@RestController
@RequestMapping("/coupon")
public class CouponController {

    @Autowired
    private CouponService couponService;

    @GetMapping
    public List<Coupon> getAllCoupons() {
        return couponService.findAllCoupons();
    }

    @PostMapping
    public Coupon createCoupon(@RequestBody Coupon coupon) {
        return couponService.saveCoupon(coupon);
    }

    @GetMapping("/{couponId}")
    public Coupon getCoupon(@PathVariable Long couponId) {
        try{
            return couponService.findById(couponId).get();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @PutMapping("/{couponId}")
    public Coupon updateCoupon(@PathVariable Long couponId, @RequestBody Coupon couponDetails) {
        return couponService.updateCoupon(couponId, couponDetails);
    }

    @DeleteMapping("/{couponId}")
    public ResponseEntity<Void> deleteCoupon(@PathVariable Long couponId) {
        couponService.deleteCoupon(couponId);
        return ResponseEntity.ok().build();
    }
}
