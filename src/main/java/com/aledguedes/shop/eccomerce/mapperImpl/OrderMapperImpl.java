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
                .to_remove(orderRequest.getTo_remove())
                .comments(orderRequest.getComments())
                .status(orderRequest.getStatus())
                .customer(orderRequest.getCustomer())
                .itemsOrder(orderRequest.getItemsOrder())
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
                .to_remove(order.getTo_remove())
                .comments(order.getComments())
                .status(order.getStatus())
                .customer(order.getCustomer())
                .itemsOrder(order.getItemsOrder())
                .build();
    }

}
