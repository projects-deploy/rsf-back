package com.aledguedes.shop.eccomerce.mapperImpl;

import org.springframework.stereotype.Component;

import com.aledguedes.shop.eccomerce.dtoRequest.OrderRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.OrderResponse;
import com.aledguedes.shop.eccomerce.mapper.OrderMapper;
import com.aledguedes.shop.eccomerce.model.Order;

@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public Order toOrder(OrderRequest orderRequest) {
        if (orderRequest == null) {
            return null;
        }

        return Order.builder()
                .dateOrder(orderRequest.getDate_order())
                .value_total(orderRequest.getValue_total())
                .shipping(orderRequest.getShipping())
                .comments(orderRequest.getComments())
                .payment(orderRequest.getPayment())
                .status(orderRequest.getStatus())
                .customer(orderRequest.getCustomer())
                .items(orderRequest.getItems())
                .build();
    }

    @Override
    public OrderResponse toOrderResponse(Order order) {
        if (order == null) {
            return null;
        }

        return OrderResponse.builder()
                .id(order.getId())
                .date_order(order.getDateOrder())
                .value_total(order.getValue_total())
                .shipping(order.getShipping())
                .comments(order.getComments())
                .payment(order.getPayment())
                .status(order.getStatus())
                .customer(order.getCustomer())
                .receiptNumber(order.getReceiptNumber())
                .items(order.getItems())
                .build();
    }

}
