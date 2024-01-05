package com.aledguedes.shop.eccomerce.mapper;

import com.aledguedes.shop.eccomerce.dtoRequest.CouponRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.CouponResponse;
import com.aledguedes.shop.eccomerce.model.Coupon;

public interface CouponMapper {

    Coupon toCoupon(CouponRequest couponRequest);
    CouponResponse toCouponResponse(Coupon coupon);
}