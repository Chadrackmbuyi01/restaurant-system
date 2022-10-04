/**
 * PaymentRepository.java
 * Payment Repository for Restaurant System
 * Author: Uwais Ali Rawoot (216217296)
 * Date: 09 April 2022
 */

package za.ac.cput.repository;

import za.ac.cput.domain.Payment;

import java.util.Set;
import java.util.HashSet;
import java.util.Optional;

public class PaymentRepository implements IPaymentRepository{
    private static PaymentRepository paymentRepository = null;
    private Set<Payment> paymentDB = null;

    private PaymentRepository(){
        paymentDB = new HashSet<Payment>();
    }

    public static PaymentRepository getPaymentRepository(){
        if (paymentRepository == null){
            paymentRepository = new PaymentRepository();
        }
        return paymentRepository;
    }

    //adding create method
    @Override
    public Payment create (Payment paymentId){
        boolean success = paymentDB.add(paymentId);
        if (!success)
            return null;
        return paymentId;
    }

    //adding read method
    @Override
    public Payment read (String paymentId){
        Payment payment = paymentDB.stream()
                .filter(p -> p.getPaymentId().equals(p.getPaymentId()))
                .findAny()
                .orElse(null);
        return payment;
    }

    //adding update method
    @Override
    public Payment update(Payment paymentId){
        Payment oldPaymentId = read(paymentId.getPaymentId());
        if (oldPaymentId != null){
            paymentDB.remove(oldPaymentId);
            paymentDB.add(paymentId);
            return paymentId;
        }
        return null;
    }

    //adding delete method
    @Override
    public boolean delete(String paymentId){
        Payment paymentIdToDelete = read((paymentId));
        if (paymentIdToDelete == null)
            return false;
        paymentDB.remove(paymentIdToDelete);
        return true;
    }

    //adding get all method
    @Override
    public Set<Payment> getAll(){
        return paymentDB;
    }

    @Override
    public Payment save(Payment payment) {
        return null;
    }

    @Override
    public Optional<Payment> findById(String s) {
        return Optional.empty();
    }

    @Override
    public Object findAll() {
        return null;
    }
}


