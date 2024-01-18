package com.aledguedes.shop.eccomerce.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aledguedes.shop.eccomerce.dtoRequest.OrderRequest;
import com.aledguedes.shop.eccomerce.dtoResponse.OrderResponse;
import com.aledguedes.shop.eccomerce.service.OrderService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {
    
    private final OrderService orderService;

    @GetMapping
    public List<OrderResponse> listAll() {
        return orderService.listAll();
    }

    @GetMapping(value = "/{order_id}")
    public OrderResponse listById(@PathVariable Long order_id) {
        return orderService.listById(order_id);
    }

    @GetMapping(value = "/chage-status/{order_id}")
    public OrderResponse changeStatus(@PathVariable Long order_id, @RequestParam(name="status") Integer status) {
        return orderService.changeStatus(order_id, status);
    }

    @GetMapping(value = "/by-receipt/{receipt_number}")
    public OrderResponse getOrderByReceiptNumber(@PathVariable String receipt_number) {
        return orderService.listOrderByReceiptNumber(receipt_number);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponse createOrder(
    		@RequestParam(name = "code", required = true, defaultValue = "") String code,
    		@RequestBody @Valid OrderRequest orderRequest) {
        return orderService.createOrder(orderRequest, code);
    }

    @PutMapping(value = "/{order_id}")
    public OrderResponse updateOrder(@RequestBody @Valid OrderRequest orderRequest, @PathVariable Long order_id) {
        return orderService.updateOrder(orderRequest, order_id);
    }
    
    /*
     * 

    @GetMapping(value = "/search/by-period")
    public List<OrderResponse> searchByPeriod(@RequestParam("date_start") String date_start, @RequestParam("date_end") String date_end) {

        LocalDate ini = LocalDate.parse(date_start);
		LocalDate fim = LocalDate.parse(date_end);
        return orderService.searchByPeriod(ini, fim);
    }

    @GetMapping(value = "/search/by-uncaceled")
    public List<OrderResponse> searchUncanceled() {
        return orderService.searchUncanceled();
    }

    @GetMapping(value = "/search/by-status") // /search/by-status?q=1
    public List<OrderResponse> searchByStatus(@RequestParam(name="q") String status) {
        var toInteger = Integer.parseInt(status);
        return orderService.searchByStatus(toInteger);
    }
    
    */

    
}
