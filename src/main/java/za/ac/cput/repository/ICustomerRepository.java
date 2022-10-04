/* ICustomerRepository.java
  Customer Repository
  Author: Ismail Watara
  Student Number: 219018790
  Date: April 2022
*/

package za.ac.cput.repository;

import za.ac.cput.domain.Customer;

import java.util.Set;

public interface ICustomerRepository extends IRepository<Customer, String> {


    public Set<Customer> getAll();
}
