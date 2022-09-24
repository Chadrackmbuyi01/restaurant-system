/* EmployeeRepository.java
   Employee Repository class for Restaurant management system
   Author: Chadrack Mbuyi Kalala (219013012)
   Date: 08 April 2022
 */
package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
