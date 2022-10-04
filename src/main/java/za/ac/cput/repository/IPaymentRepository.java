/**
 * IPaymentRepository.java
 * Payment Repository Interface for Payment Repository in Restaurant System
 * Author: Uwais Ali Rawoot (216217296)
 * Date: 09 April 2022
 */

package za.ac.cput.repository;

import za.ac.cput.domain.Payment;
import java.util.Set;
import java.util.Optional;

public interface IPaymentRepository extends IRepository <Payment, String>{
    public Set<Payment> getAll();

    Payment save(Payment payment);

    Optional<Payment> findById(String s);

    Object findAll();
}
