package com.lambdaschool.orders.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
//not mandatory, but creating a table name will save me headaches.
@Table(name="Agents")

public class Agents {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable=false)
    private long agentcode;

    private String agentname;
    private String workingarea;
    private Double commission;
    private String phone;
    private String country;

    @OneToMany(mappedBy = "agent")
    private List<Customers> customers = new ArrayList<>();

    public Agents() {
    }

    public Agents(String agentname, String workingarea, Double commission, String phone, String country) {
        this.agentname = agentname;
        this.workingarea = workingarea;
        this.commission = commission;
        this.phone = phone;
        this.country = country;
    }

    public Long getAgentcode() {
        return agentcode;
    }

    public void setAgentcode(Long agentcode) {
        this.agentcode = agentcode;
    }

    public String getAgentname() {
        return agentname;
    }

    public void setAgentname(String agentname) {
        this.agentname = agentname;
    }

    public String getWorkingarea() {
        return workingarea;
    }

    public void setWorkingarea(String workingarea) {
        this.workingarea = workingarea;
    }

    public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Customers> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customers> customers) {
        this.customers = customers;
    }
}
