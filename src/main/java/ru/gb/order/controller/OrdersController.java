package ru.gb.order.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ru.gb.order.dao.OrdersDao;
import ru.gb.order.model.OrdersDto;
import ru.gb.order.model.mapper.OrdersMapper;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrdersController {
    @Autowired
    private OrdersDao ordersDao;
    @Autowired
    private OrdersMapper ordersMapper;

    @GetMapping
    @Transactional
    public List<OrdersDto> getOrders() {
//        return ordersMapper.toOrdersDto(ordersDao.findById(1L).get());
        return ordersDao.findAll().stream().map(p -> ordersMapper.toOrdersDto(p)).collect(Collectors.toList());
    }
}
