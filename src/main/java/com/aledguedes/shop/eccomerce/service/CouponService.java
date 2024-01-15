package com.aledguedes.shop.eccomerce.service;

import java.util.List;

import com.aledguedes.shop.eccomerce.dtoRequest.CouponRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.CouponResponse;

public interface CouponService {
    
    List<CouponResponse> listAll();
    CouponResponse couponById(Long coupon_id);
    CouponResponse createCoupon(CouponRequest coupon, Integer expirationDays, String customer);
    CouponResponse updateCoupon(CouponRequest coupon, Long coupon_id);
    void deleteCoupon(Long coupon_id);

    CouponResponse applyCoupon(String code, Long customer_id);
    
    // List<CouponResponse> cuponsByProduct(Product product);
    // List<CouponResponse> cuponsByCustomer(Customer customer);
    // List<CouponResponse> listByCodeProduct(String code, Product product);
    // List<CouponResponse> listByCodeCustomer(String code, Customer customer);
    // List<CouponResponse> cuponsByCodeAndProduct(String code, Product product);
    // List<CouponResponse> cuponsByCodeAndCustomer(String code, Customer customer);
    // List<CouponResponse> cuponsByCustomerAndProduct(Customer customer, Product product);
    // List<CouponResponse> cuponsByCodeAndExpirationDate(String code, LocalDateTime expirationDate);
    // List<CouponResponse> cuponsByCodeAndCustomerAndProduct(String code, Customer customer, Product product);
}
