package za.ac.cput.service.entity;

import za.ac.cput.domain.Payment;
import za.ac.cput.service.IService;

import java.util.List;

public interface PaymentService extends IService <Payment, String>{
    List<Payment> getAll();
}
