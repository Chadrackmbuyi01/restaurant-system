package za.ac.cput.service.entity.impl;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.Customer;
import za.ac.cput.repository.CustomerRepository;
import za.ac.cput.service.entity.CustomerService;


import java.util.List;
import java.util.Optional;

//@Service
public class CustomerServiceImpl implements CustomerService {

    protected CustomerRepository repository;
    @Autowired
    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }


    @Override
    public Customer save(Customer customer) {
        return null;//this.repository.save(Customer);
    }

    @Override
    public Optional<Customer> read(Integer integer) {
        return Optional.empty();
    }



    @Override
    public void delete(Customer customer) {

        this.repository.delete(String.valueOf(customer));
    }

    @Override
    public List<Customer> getAll() {
        return null;//(List<Customer>) this.repository.findAll();
    }
}