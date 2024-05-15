package com.talenthub.AccountManager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talenthub.AccountManager.model.Coupon;
import com.talenthub.AccountManager.repository.CouponRepository;

@Service
public class CouponService {


    private final CouponRepository couponRepository;

    @Autowired
    public CouponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    public List<Coupon> findAllCoupons() {
        return couponRepository.findAll();
    }

    public Coupon saveCoupon(Coupon coupon) {
        return couponRepository.save(coupon);
    }

    public Optional<Coupon> findById(Long id) {
        return couponRepository.findById(id);
    }

    public Coupon updateCoupon(Long id, Coupon newCoupon) {
        return couponRepository.findById(id)
            .map(coupon -> {
                coupon.setName(newCoupon.getName());
                coupon.setDescription(newCoupon.getDescription());
                coupon.setExpirationdate((newCoupon.getExpirationdate()));
                coupon.setStatus(newCoupon.getStatus());
                coupon.setCompanyId(newCoupon.getCompanyId());
                coupon.setDiscountRate(newCoupon.getDiscountRate());  
                coupon.setCompanyid(newCoupon.getCompanyid());
                return couponRepository.save(coupon);
            })
            .orElseGet(() -> {
                newCoupon.setId(id);
                return couponRepository.save(newCoupon);
            });
    }

    public void deleteCoupon(Long id) {
        couponRepository.deleteById(id);
    }
}
