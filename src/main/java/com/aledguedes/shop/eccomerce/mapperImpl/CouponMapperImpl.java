package com.aledguedes.shop.eccomerce.mapperImpl;

import org.springframework.stereotype.Component;

import com.aledguedes.shop.eccomerce.dtoRequest.CouponRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.CouponResponse;
import com.aledguedes.shop.eccomerce.mapper.CouponMapper;
import com.aledguedes.shop.eccomerce.model.Coupon;

@Component
public class CouponMapperImpl implements CouponMapper {

    @Override
    public Coupon toCoupon(CouponRequest couponRequest) {
        if (couponRequest == null) {
            return null;
        }

        return Coupon.builder()
                .discountType(couponRequest.getDiscountType())
                .discount(couponRequest.getDiscount())
                .build();
    }

    @Override
    public CouponResponse toCouponResponse(Coupon coupon) {
        if (coupon == null) {
            return null;
        }

        return CouponResponse.builder()
                .id(coupon.getId())
                .code(coupon.getCode())
                .discount(coupon.getDiscount())
                .couponType(coupon.getCouponType())
                .discountType(coupon.getDiscountType())
                .expiration_date(coupon.getExpiration_date())
                .active(coupon.isActive())
                .customer(coupon.getCustomer())
                .build();
    }
}
