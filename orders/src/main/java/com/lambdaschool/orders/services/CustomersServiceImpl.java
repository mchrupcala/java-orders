package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Customers;
import com.lambdaschool.orders.models.Orders;
import com.lambdaschool.orders.repositories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value="CustomersService")
public class CustomersServiceImpl implements CustomersServices {

    @Autowired
    private CustomersRepository custrepos;



    @Override
    List<Customers> getAll() {
        List<Customers> rtnCustomers = new ArrayList<>();
                    custrepos.findAll()
                    .iterator()
                    .forEachRemaining(rtnCustomers::add);
             return rtnCustomers;
    }

    @Override
    Customers save(Customers customer) {
        Customers newCustomer = new Customers();

        newCustomer.setCustname(customer.getCustname());
        newCustomer.setCustcity(customer.getCustcity());
        newCustomer.setWorkingarea(customer.getWorkingarea());
        newCustomer.setCustcountry(customer.getCustcountry());
        newCustomer.setGrade(customer.getGrade());
        newCustomer.setOpeningamt(customer.getOpeningamt());
        newCustomer.setReceiveamt(customer.getReceiveamt());
        newCustomer.setPaymentamt(customer.getPaymentamt());
        newCustomer.setOutstandingamt(customer.getOutstandingamt());
        newCustomer.setPhone(customer.getPhone());

        for (Orders o : customer.getOrders()) {
            newCustomer.getOrders().add(new Orders(o.getOrdamount(),
                    o.getAdvanceamount(),
                    o.getOrddescription(),
                    newCustomer))
        }
        return null;
    }

    @Override
    Customers update(Customers customer, long custcode) {
        return super.update(customer, custcode);
    }

    @Override
    void deleteCustomer(long custcode) {
        super.deleteCustomer(custcode);
    }
}
