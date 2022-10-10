/**
 * IPaymentRepository.java
 * Payment Repository Interface for Payment Repository in Restaurant System
 * Author: Uwais Ali Rawoot (216217296)
 * Date: 09 April 2022
 */

package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Payment;
import java.util.Set;
import java.util.Optional;
@Repository
public interface IPaymentRepository extends JpaRepository<Payment, String> {

}
