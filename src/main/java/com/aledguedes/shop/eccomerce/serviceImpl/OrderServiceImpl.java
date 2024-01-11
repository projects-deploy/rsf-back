package com.aledguedes.shop.eccomerce.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.aledguedes.shop.eccomerce.dtoRequest.OrderRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.OrderResponse;
import com.aledguedes.shop.eccomerce.exceptions.core.DepartmentNotFoundException;
import com.aledguedes.shop.eccomerce.exceptions.core.OrderNotFoundException;
import com.aledguedes.shop.eccomerce.mapper.OrderMapper;
import com.aledguedes.shop.eccomerce.model.ItemOrder;
import com.aledguedes.shop.eccomerce.model.Order;
import com.aledguedes.shop.eccomerce.repository.CustomerRepository;
import com.aledguedes.shop.eccomerce.repository.ItemOrderRepository;
import com.aledguedes.shop.eccomerce.repository.OrderRepository;
import com.aledguedes.shop.eccomerce.repository.ProductRepository;
import com.aledguedes.shop.eccomerce.service.OrderService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@SuppressWarnings("null")
public class OrderServiceImpl implements OrderService {

	private final OrderMapper orderMapper;
	private final OrderRepository orderRepository;
	private final ProductRepository productRepository;
	private final CustomerRepository customerRepository;
	private final ItemOrderRepository itemOrderRepository;

	@Override
	public List<OrderResponse> listAll() {
		return orderRepository.findAll().stream().map(orderMapper::toOrderResponse).toList();
	}

	@Override
	public OrderResponse listById(Long order_id) {
		return orderRepository.findById(order_id).map(orderMapper::toOrderResponse)
				.orElseThrow(OrderNotFoundException::new);
	}

	@Override
	public OrderResponse createOrder(OrderRequest orderRequest) {
		try {

			var cliente = customerRepository.findById(orderRequest.getCustomer().getId())
                    .orElseThrow(DepartmentNotFoundException::new);

            var novo = orderMapper.toOrder(orderRequest);
            
            List<ItemOrder> newItems = new ArrayList<>();
            for (ItemOrder itemRequest : novo.getItems()) {
                ItemOrder newItem = new ItemOrder();
                newItem.setProduct(productRepository.findById(itemRequest.getProduct().getId()).orElse(null));
                newItem.setQtde_item(itemRequest.getQtde_item());
                newItem.setAmount(newItem.getProduct().getPrice_promo() * newItem.getQtde_item());
                newItem.setOrder(novo);
                newItems.add(newItem);
            }
            
            novo.setItems(newItems);
            novo.setStatus(Order.NOVO_PEDIDO);
            novo.setCustomer(cliente);
            
            var createdOrder = orderRepository.save(novo);
            
            for (ItemOrder newItem : newItems) {
                itemOrderRepository.save(newItem);
            }
            
            return orderMapper.toOrderResponse(createdOrder);

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public OrderResponse updateOrder(OrderRequest orderRequest, Long order_id) {
		try {
			var order = orderRepository.findById(order_id).orElseThrow(OrderNotFoundException::new);
			BeanUtils.copyProperties(orderRequest, order, "id", "createdAt", "updatedAt");
			var orderAtualizado = orderRepository.save(order);
			return orderMapper.toOrderResponse(orderAtualizado);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

//    @Override
//    public List<OrderResponse> searchUncanceled() {
//        return orderRepository.findAllByStatusNotOrderByDateOrderDesc();
//    }
//
//    @Override
//    public List<OrderResponse> searchByStatus(Integer status) {
//        return orderRepository.findAllByStatusOrderByDateOrderDesc(status);
//    }

	@Override
	public OrderResponse changeStatus(Long order_id, Integer new_status) {
		try {
			var order = orderRepository.findById(order_id).orElseThrow(OrderNotFoundException::new);
			order.setStatus(new_status);
			var newOrder = orderRepository.save(order);
			return orderMapper.toOrderResponse(newOrder);
		} catch (Exception ex) {
			return null;
		}
	}

//    @Override
//    public List<OrderResponse> searchByPeriod(LocalDate data_start, LocalDate date_end) {
//        return orderRepository.findAllByDateOrderBetweenOrderByIdOrderDesc(data_start, date_end);
//    }

}
