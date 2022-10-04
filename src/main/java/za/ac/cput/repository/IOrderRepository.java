/* IOrderRepository.java
   Order Repository
   Author: Ismail Watara
   Student Number: 219018790
   Date: April 2022
*/

package za.ac.cput.repository;

import za.ac.cput.domain.Order;

import java.util.Set;

public interface IOrderRepository extends IRepository<Order, String> {
    Order create(Order order);

    public Set<Order> getAll();
}
