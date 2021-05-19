package com.cmp404.pharmacymanagement.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class OrderItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Cart cart;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "order_id")
//    private Order order;

    private Long itemId;
    private String itemName;
    private String itemDescription;
    private Long orderQuantity;
    private BigDecimal itemPrice;

    public OrderItem() {
    }

    public OrderItem(Item item, Long quantity) {
        this.itemId = item.getId();
        this.itemName = item.getName();
        this.itemDescription = item.getDescription();
        this.orderQuantity = item.getQuantity();
        this.itemPrice = item.getPrice();
    }

    public Long getCart() {
        return cart.getId();
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public Long getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(Long orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", cart=" + cart +
                ", itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                ", orderQuantity=" + orderQuantity +
                ", itemPrice=" + itemPrice +
                '}';
    }
}
