package com.lambdaschool.orders.repositories;

import com.lambdaschool.orders.models.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<Long, Orders> {
}
