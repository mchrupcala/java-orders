package com.lambdaschool.orders.controllers;

import com.lambdaschool.orders.models.Customers;
import com.lambdaschool.orders.services.CustomersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    @PostMapping(value="new",
               consumes={"application/json"})
    public ResponseEntity<?> addNewCustomer(@Valid
                                            @RequestBody Customers newCustomer) {
        CustomersService.save(newCustomer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }



//    PUT /customer/update/{custcode} - Updates the customer based off of custcode. Does not have to do anything with Orders!
    @PutMapping(value= "/update/{custcode}",
    consumes = {"application/json"})
    public ResponseEntity<?> updateCustomer(@RequestBody Customers newCustomer,
                                            @PathVariable long custcode) {
        CustomersService.update(newCustomer, custcode);
        return new ResponseEntity<>(HttpStatus.OK);
    }


//    DELETE /customer/delete/{custcode} - Deletes the customer based off of custcode
//    this should also delete the orders of that customer

      @DeleteMapping("/delete/{custcode}")
      public ResponseEntity<?> deleteCustomer(@PathVariable long custcode) {
        CustomersService.deleteCustomer(custcode);
        return new ResponseEntity<>(HttpStatus.OK);
      }

}
