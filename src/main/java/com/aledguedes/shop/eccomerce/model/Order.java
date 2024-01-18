package com.aledguedes.shop.eccomerce.model;

import java.time.LocalDateTime;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_order")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Order extends Auditable {

    public static final int NOVO_PEDIDO = 1;
    public static final int PAGO = 2;
    public static final int EM_TRANSPORTE = 3;
    public static final int ENTREGUE = 4;
    public static final int POS_VENDA = 5;
    public static final int FINALIZADO = 6;
    public static final int CANCELADO = 7;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date_order")
    private LocalDateTime dateOrder;

    @Column(name = "value_total")
    private double value_total;

    @Column(name = "shipping")
    private String shipping;

    @Column(name = "payment")
    private String payment;

    @Column(name = "comments")
    private String comments;

    @Column(name = "status")
    private Integer status;
    
    @Column(name = "receipt_number")
    private String receiptNumber;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnoreProperties({"favorites"})
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("order")
    private List<ItemOrder> items;
}
