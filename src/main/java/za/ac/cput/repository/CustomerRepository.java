/* CustomerRepository.java
   Customer Repository
   Author: Ismail Watara
   Student Number: 219018790
   Date: April 2022
*/

package za.ac.cput.repository;

import za.ac.cput.domain.Customer;

import java.util.HashSet;
import java.util.Set;

public class CustomerRepository implements ICustomerRepository{
    private static CustomerRepository repository = null;
    private Set<Customer> customerDB = null;

    private CustomerRepository(){
        customerDB = new HashSet<Customer>();
    }

    public static CustomerRepository getRepository(){
        if (repository ==null){
            repository = new CustomerRepository();

        }
        return repository;
    }


    @Override
    public Customer create(Customer customer){
        this.customerDB.add(customer);
        return customer;
    }



    @Override
    public Customer read(String custId){
        for (Customer c: customerDB) {
            if (c.getCustId().equals(custId)){
                return c;
            }

        }
        return null;
    }
    @Override
    public Customer update(Customer customer) {
        Customer firstCustomer = read(customer.getCustId());
        if( firstCustomer !=null) {
            customerDB.remove(firstCustomer);
            customerDB.add(customer);
            return customer;
        }
        return null;
    }



    @Override
    public boolean delete(String custId) {
        Customer deleteCustomer = read(custId);
        if (deleteCustomer ==null) {
            System.out.println("Customer is null.");
        }
        customerDB.remove(deleteCustomer);
        System.out.println("Customer has been removed.");
        return false;
    }
    @Override
    public Set<Customer> getAll(){return customerDB;}
}
