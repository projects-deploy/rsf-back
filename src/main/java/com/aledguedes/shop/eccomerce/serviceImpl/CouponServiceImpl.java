package com.aledguedes.shop.eccomerce.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.aledguedes.shop.eccomerce.dtoRequest.CouponRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.CouponResponse;
import com.aledguedes.shop.eccomerce.exceptions.core.CouponNotFoundException;
import com.aledguedes.shop.eccomerce.exceptions.core.UserNotFoundException;
import com.aledguedes.shop.eccomerce.exceptions.coupons.InactiveCouponException;
import com.aledguedes.shop.eccomerce.exceptions.coupons.InvalidCustomerCouponException;
import com.aledguedes.shop.eccomerce.mapper.CouponMapper;
import com.aledguedes.shop.eccomerce.repository.CouponRepository;
import com.aledguedes.shop.eccomerce.repository.CustomerRepository;
import com.aledguedes.shop.eccomerce.service.CouponService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@SuppressWarnings("null")
public class CouponServiceImpl implements CouponService {

	private final CouponMapper couponMapper;
	private final CouponRepository couponRepository;
	private final CustomerRepository customerRepository;
	// private final ProductRepository productRepository;

	@Override
	public List<CouponResponse> listAll() {
		return couponRepository.findAll().stream().map(couponMapper::toCouponResponse).toList();
	}

	@Override
	public CouponResponse couponById(Long coupon_id) {
		return couponRepository.findById(coupon_id).map(couponMapper::toCouponResponse)
				.orElseThrow(CouponNotFoundException::new);
	}

	@Override
	public CouponResponse createCoupon(CouponRequest couponRequest, Integer expirationDays, String customer) {
		try {
			var newCoupon = couponMapper.toCoupon(couponRequest);

			LocalDateTime expirationDate = LocalDateTime.now().plusDays(expirationDays);
			String value = couponRequest.getDiscount() < 10 ? String.format("%02d", couponRequest.getDiscount())
					: couponRequest.getDiscount().toString();
			String code = "SHOPFASHION" + value;

			newCoupon.setCode(code);
			newCoupon.setActive(true);
			newCoupon.setExpiration_date(expirationDate);

			if (!customer.isEmpty()) {
				long customer_id = Long.parseLong(customer);
				var user = customerRepository.findById(customer_id)
						.orElseThrow(UserNotFoundException::new);
				newCoupon.setCustomer(user);
				newCoupon.setCouponType("customerCoupon");
			} else {
				newCoupon.setCouponType("singleCoupon");
			}

			var createdCoupon = couponRepository.save(newCoupon);
			return couponMapper.toCouponResponse(createdCoupon);
		} catch (Exception e) {
			System.out.println("DEBUG CREATE COUPON = " + e.getMessage());
			return null;
		}
	}

	@Override
	public CouponResponse updateCoupon(CouponRequest couponRequest, Long coupon_id) {
		try {
			var coupon = couponRepository.findById(coupon_id).orElseThrow(CouponNotFoundException::new);
			BeanUtils.copyProperties(couponRequest, coupon, "id", "createdAt", "updatedAt");
			var couponAtualizado = couponRepository.save(coupon);
			return couponMapper.toCouponResponse(couponAtualizado);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public void deleteCoupon(Long coupon_id) {
		try {
			couponRepository.deleteById(coupon_id);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public CouponResponse applyCoupon(String code, Long customer_id) {
		var coupon = couponRepository.findByCode(code).orElseThrow(CouponNotFoundException::new);
		if (!coupon.isAtivo()) {
			throw new InactiveCouponException();
		}

		if ("customerCoupon".equals(coupon.getCouponType()) && !coupon.getCustomer().getId().equals(customer_id)) {
			throw new InvalidCustomerCouponException();
		}
		return couponMapper.toCouponResponse(coupon);

	}
}
