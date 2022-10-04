package za.ac.cput.service.entity;



import za.ac.cput.domain.Customer;
import za.ac.cput.service.IService;
import java.util.List;

public interface CustomerService extends IService<Customer,Integer> {
    List<Customer> getAll();
}