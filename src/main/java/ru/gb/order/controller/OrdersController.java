package ru.gb.order.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.gb.order.dao.OrdersDao;
import ru.gb.order.entity.Orders;
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
        return ordersDao.findAll().stream().map(p -> ordersMapper.toOrdersDto(p)).collect(Collectors.toList());
    }

    @PostMapping("/create")
    public Orders create(@RequestBody Orders order) {
        return ordersDao.save(order);
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<?> handleUpdate(@PathVariable("orderId") Long id, @Validated @RequestBody OrdersDto orderDto) {
        orderDto.setId(id);
        ordersDao.save(ordersMapper.toOrders(orderDto));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{orderId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable("orderId") Long id) {
        ordersDao.deleteById(id);
    }

}
