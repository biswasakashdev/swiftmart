package com.biswasakashdev.swiftmart.gateway.controller;


import com.biswasakashdev.swiftmart.gateway.dtos.inputs.PageInfo;
import com.biswasakashdev.swiftmart.gateway.dtos.models.*;
import com.biswasakashdev.swiftmart.gateway.dtos.models.orders.*;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class OrderController {

    @QueryMapping
    public Order getOrder(
            @Argument String shopId,
            @Argument String id
    ) {
        Customer customer = new Customer(
                "", "test@example.com", "John", "Doe", List.of(), java.time.LocalDateTime.now()
        );
        LineItem item = new LineItem(1L, 1L, "Variant A", 2, 99.99);
        return new Order(
                id,
                customer,
                List.of(item),
                199.98,
                OrderFinancialStatus.PAID,
                OrderFulfillmentStatus.FULFILLED,
                java.time.LocalDateTime.now()
        );
    }

    @QueryMapping
    public OrderList getOrdersAdmin(
            @Argument String shopId,
            @Argument PageInfo pageInfo) {
        // Stubbed example: fetch orders for a shop
        List<Order> orders = List.of(
                new Order(
                        "",
                        new Customer("", "admin@example.com", "Admin", "User", List.of(), java.time.LocalDateTime.now()),
                        List.of(new LineItem(1L, 1L, "Variant A", 2, 99.99)),
                        199.98,
                        OrderFinancialStatus.PAID,
                        OrderFulfillmentStatus.FULFILLED,
                        java.time.LocalDateTime.now()
                )
        );

        PageDetails pageDetails = new PageDetails(
                1,
                10,
                12L,
                false
        );


        return new OrderList(pageDetails,orders);
    }

    @QueryMapping
    public OrderList getOrderCustomer(@Argument String shopId, @Argument PageInfo pageInfo, @Argument String customerId) {
        // Stubbed example: fetch orders for a specific customer
        Customer customer = new Customer(
                customerId,
                "customer@example.com",
                "Alice",
                "Smith",
                List.of(),
                java.time.LocalDateTime.now()
        );

        List<Order> orders = List.of(
                new Order(
                        "",
                        customer,
                        List.of(new LineItem(2L, 1L, "Variant B", 1, 49.99)),
                        49.99,
                        OrderFinancialStatus.PENDING,
                        OrderFulfillmentStatus.UNFULFILLED,
                        java.time.LocalDateTime.now()
                )
        );


        PageDetails pageDetails = new PageDetails(
                1,
                10,
                12L,
                false
        );


        return new OrderList(pageDetails,orders);
    }

}
