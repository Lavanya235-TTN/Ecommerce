package com.learn.project.Bootcamp.Project.model.Orders;

import javax.persistence.*;

@Entity
public class OrderStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @MapsId
    private OrderProduct orderProduct;

    @Enumerated(EnumType.STRING)
    private com.learn.project.Bootcamp.Project.enums.fromStatus fromStatus;

    @Enumerated(EnumType.STRING)
    private com.learn.project.Bootcamp.Project.enums.fromStatus toStatus;

    private String transitionNotesComments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderProduct getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(OrderProduct orderProduct) {
        this.orderProduct = orderProduct;
    }

    public com.learn.project.Bootcamp.Project.enums.fromStatus getFromStatus() {
        return fromStatus;
    }

    public void setFromStatus(com.learn.project.Bootcamp.Project.enums.fromStatus fromStatus) {
        this.fromStatus = fromStatus;
    }

    public com.learn.project.Bootcamp.Project.enums.fromStatus getToStatus() {
        return toStatus;
    }

    public void setToStatus(com.learn.project.Bootcamp.Project.enums.fromStatus toStatus) {
        this.toStatus = toStatus;
    }

    public String getTransitionNotesComments() {
        return transitionNotesComments;
    }

    public void setTransitionNotesComments(String transitionNotesComments) {
        this.transitionNotesComments = transitionNotesComments;
    }
}