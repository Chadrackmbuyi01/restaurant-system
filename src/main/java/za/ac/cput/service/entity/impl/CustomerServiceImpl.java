package za.ac.cput.service.entity.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Customer;
import za.ac.cput.repository.ICustomerRepository;
import za.ac.cput.service.entity.CustomerService;


import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    protected ICustomerRepository repository;
    @Autowired
    public CustomerServiceImpl(ICustomerRepository repository) {
        this.repository = repository;
    }


    @Override
    public Customer save(Customer customer) {
        return this.repository.save(customer);
    }

    @Override
    public Optional<Customer> read(Integer integer) {
        return this.repository.findById(String.valueOf(integer));
    }


    @Override
    public void delete(Customer customer) {

        this.repository.delete(customer);
    }

    @Override
    public List<Customer> getAll() {
        return this.repository.findAll();
    }

    @Override
    public void deleteById(String custId) {

    }
}