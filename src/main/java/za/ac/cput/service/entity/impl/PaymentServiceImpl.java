package za.ac.cput.service.entity.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Payment;
import za.ac.cput.repository.IPaymentRepository;
import za.ac.cput.service.entity.PaymentService;

import java.util.List;
import java.util.Optional;

    @Service
    public class PaymentServiceImpl implements PaymentService {

        protected IPaymentRepository repository;

        @Autowired
        public PaymentServiceImpl(IPaymentRepository repository) {
            this.repository = repository;
        }


        @Override
        public Payment save(Payment payment) {
            return this.repository.save(payment);
        }

        @Override
        public Optional<Payment> read(String s) {
            return this.repository.findById(s);
        }

        @Override
        public void delete(Payment payment) {
            this.repository.delete(String.valueOf(payment));
        }

        @Override
        public List<Payment> getAll() {
            return (List<Payment>) this.repository.findAll();
        }
    }
