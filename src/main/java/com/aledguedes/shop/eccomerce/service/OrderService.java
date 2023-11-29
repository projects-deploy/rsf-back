package com.aledguedes.shop.eccomerce.service;

import java.util.List;

import com.aledguedes.shop.eccomerce.dtoRequest.OrderRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.OrderResponse;

public interface OrderService {
	public List<OrderResponse> listAll();
	public OrderResponse listById(Long order_id);
    public OrderResponse createOrder(OrderRequest orderRequest);
	public OrderResponse updateOrder(OrderRequest orderRequest, Long order_id);
//	public List<OrderResponse> searchUncanceled();
//	public List<OrderResponse> searchByStatus(Integer status);
	public OrderResponse changeStatus(Long order_id, Integer new_status);
//	public List<OrderResponse> searchByPeriod(LocalDate data_start, LocalDate date_end);

	// public List<OrderResponse> filtrarPorVariosCriterios(FiltroOrderResponseDTO filtro);
	// public List<VendasPorDataDTO> recuperarTotaisUltimaSemana(LocalDateTime inicio, LocalDateTime fim);
}
