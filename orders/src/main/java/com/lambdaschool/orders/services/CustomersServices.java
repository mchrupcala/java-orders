package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Customers;

import java.util.List;

public interface CustomersServices {

    List<Customers> getAll();

    Customers save(Customers customer);

//    Customers update(Customers customer,
//                     long custcode);

//    void deleteCustomer(long custcode);
}
