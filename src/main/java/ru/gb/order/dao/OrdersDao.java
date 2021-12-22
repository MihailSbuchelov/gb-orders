package ru.gb.order.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.order.entity.Orders;

public interface OrdersDao extends JpaRepository<Orders, Long> {
}
