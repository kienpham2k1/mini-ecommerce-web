package com.springboot.miniecommercewebapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "tblOrderDetails", schema = "dbo", catalog = "MiniEcommerce")
public class OrderDetailEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "detailID", nullable = false)
    private Integer detailId;
    @Basic
    @Column(name = "quantity", nullable = false)
    private int quantity;
    @Basic
    @Column(name = "price", nullable = false, precision = 0)
    private double price;
    @Basic
    @Column(name = "orderID", nullable = true)
    private Integer orderId;
    @Basic
    @Column(name = "productID", nullable = false)
    private int productId;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "orderID", referencedColumnName = "orderID",
            insertable = false, updatable=false)
    private OrderEntity tblOrdersByOrderId;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "productID", referencedColumnName = "productID", nullable = false,
            insertable = false, updatable=false)
    private ProductEntity tblProductsByProductId;
}