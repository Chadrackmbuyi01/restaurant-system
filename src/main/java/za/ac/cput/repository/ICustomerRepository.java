/* ICustomerRepository.java
  Customer Repository
  Author: Ismail Watara
  Student Number: 219018790
  Date: April 2022
*/

package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, String> {

}
