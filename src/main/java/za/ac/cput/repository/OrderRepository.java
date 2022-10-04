/* OrderRepository.java
   Order Repository
   Author: Ismail Watara
   Student Number: 219018790
   Date: April 2022
*/
package za.ac.cput.repository;

import za.ac.cput.domain.Order;

import java.util.HashSet;
import java.util.Set;

public class OrderRepository implements IOrderRepository {

    private static OrderRepository repository = null;
    private Set<Order> orderDB;

    private OrderRepository(){this.orderDB = new HashSet<>();}


    public static OrderRepository getRepository() {

        if(repository == null) {
            repository = new OrderRepository();
        }
        return repository;
    }




    @Override
    public Order create(Order order) {
        this.orderDB.add(order);
        return order;

    }

    @Override
    public Order read(String orderId ) {
        for (Order ord : orderDB) {
            if (ord.getOrderId().equals(orderId))
                return ord;
        }
        return null;
    }

    @Override
    public Order update(Order order) {
        Order firstOrder = read(order.getOrderId());
        if (firstOrder != null){
            orderDB.remove(firstOrder);
            orderDB.add(order);
            return order;

        }
        return null;
    }

    @Override
    public boolean delete(String orderId) {
        Order deleteOrder = read(orderId);
        if (deleteOrder == null){
            System.out.println("Order is null");
        }
        orderDB.remove(deleteOrder);
        System.out.println("Order removed");

        return false;
    }

    @Override
    public Set<Order> getAll() {
        return null;
    }
}
