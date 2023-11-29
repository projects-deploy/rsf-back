package com.aledguedes.shop.eccomerce.mapper;

import com.aledguedes.shop.eccomerce.dtoRequest.OrderRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.OrderResponse;
import com.aledguedes.shop.eccomerce.model.Order;

public interface OrderMapper {
    
    Order toOrder(OrderRequest orderRequest);
    OrderResponse toOrderResponse(Order order);
}
