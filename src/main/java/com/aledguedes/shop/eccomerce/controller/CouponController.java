package com.aledguedes.shop.eccomerce.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aledguedes.shop.eccomerce.dtoRequest.CouponRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.CouponResponse;
import com.aledguedes.shop.eccomerce.service.CouponService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/coupon")
public class CouponController {

    private final CouponService couponService;

    @GetMapping
    public List<CouponResponse> listAll() {
        return couponService.listAll();
    }

    @GetMapping(value = "/{coupon_id}")
    public CouponResponse couponById(@PathVariable Long coupon_id) {
        return couponService.couponById(coupon_id);
    }

    @GetMapping(value = "/apply")
    public CouponResponse applyCoupon(
        @RequestParam(name = "code", required = true, defaultValue = "") String code,
        @RequestParam(name = "customer", required = false, defaultValue = "") Long customer
    ) {
        return couponService.applyCoupon(code, customer);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CouponResponse createCoupon(
    		@RequestBody @Valid CouponRequest coupon,
    		@RequestParam(name = "days", required = false, defaultValue = "0") Integer expirationDays,
    		@RequestParam(name = "customer", required = false, defaultValue = "") String customer) {
        return couponService.createCoupon(coupon, expirationDays, customer);
    }

    @PutMapping(value = "/{coupon_id}")
    public CouponResponse updateCoupon(@RequestBody @Valid CouponRequest coupon, @PathVariable Long coupon_id) {
        return couponService.updateCoupon(coupon, coupon_id);
    }

    @DeleteMapping("/{coupon_id}")
    public void deleteCoupon(@PathVariable Long coupon_id) {
        couponService.deleteCoupon(coupon_id);
    }

}
