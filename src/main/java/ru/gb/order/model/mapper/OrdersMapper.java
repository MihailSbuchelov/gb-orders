package ru.gb.order.model.mapper;

import org.mapstruct.Mapper;
import ru.gb.order.entity.Orders;
import ru.gb.order.model.OrdersDto;

@Mapper
public interface OrdersMapper {
    Orders toOrders(OrdersDto ordersDto);

    OrdersDto toOrdersDto(Orders orders);
}
