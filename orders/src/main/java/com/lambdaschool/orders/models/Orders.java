package com.lambdaschool.orders.models;

import javax.persistence.*;

@Entity
@Table(name="Orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private long ordnum;

    private double ordamount;
    private double advanceamount;
    private String orddescription;


    @ManyToOne
    @JoinColumn(name="custcode",
                nullable=false)
    private Customers customer;

    public Orders() {
    }

    public Orders(double ordamount, double advanceamount, Customers customer, String orddescription) {
        this.ordamount = ordamount;
        this.advanceamount = advanceamount;
        this.customer = customer;
        this.orddescription = orddescription;
    }

    public Long getOrdnum() {
        return ordnum;
    }

    public void setOrdnum(Long ordnum) {
        this.ordnum = ordnum;
    }

    public double getOrdamount() {
        return ordamount;
    }

    public void setOrdamount(double ordamount) {
        this.ordamount = ordamount;
    }

    public double getAdvanceamount() {
        return advanceamount;
    }

    public void setAdvanceamount(double advanceamount) {
        this.advanceamount = advanceamount;
    }

    public String getOrddescription() {
        return orddescription;
    }

    public void setOrddescription(String orddescription) {
        this.orddescription = orddescription;
    }
}
