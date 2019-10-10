package com.lambdaschool.orders.controllers;

import com.lambdaschool.orders.models.Customers;
import com.lambdaschool.orders.services.CustomersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomersController {

//    GET /customer/order - Returns all customers with their orders
    @Autowired
    private CustomersServices CustomersService;

    @GetMapping(value="/order",
    produces = {"application/json"})

    public ResponseEntity<?> getAllCustomers(){
    List<Customers> newList = CustomersService.getAll();
            return new ResponseEntity<>(newList, HttpStatus.OK);
    }

//    POST /customer/new - Adds a new customer including any new orders
//
//    PUT /customer/update/{custcode} - Updates the customer based off of custcode. Does not have to do anything with Orders!
//
//    DELETE /customer/delete/{custcode} - Deletes the customer based off of custcode
//    this should also delete the orders of that customer

}
