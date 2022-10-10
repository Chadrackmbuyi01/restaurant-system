package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.service.entity.CustomerService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("restaurant/customer/")
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("save")
    public ResponseEntity<Customer> save(@Valid @RequestBody Customer gender) {
        log.info("Save request:{}",gender);
        //System.out.println("save" +""+ gender);
        Customer cu;
        try{
            cu = CustomerFactory.createcustomer(gender.getCustId(), gender.getCustFirstName(), gender.getCustLastName(),
                    gender.getCustCellNum(), gender.getCustEmail());
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        Customer save = this.customerService.save(gender);
        return ResponseEntity.ok(save);
    }

    private Optional<Customer> getById(String custId){
        return this.customerService.read(Integer.valueOf(custId));
    }

    @GetMapping("read/{custId}")
    public ResponseEntity<Customer> read(@PathVariable String custId) {
        log.info("Read request:{}",custId);
        //System.out.println("read" +""+ custId);
        Customer read = this.customerService.read(Integer.valueOf(custId))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(read);
    }

    @DeleteMapping("delete/{custId}")
    public ResponseEntity<Void> delete(@PathVariable String custId) {
        log.info("delete request:{}",custId);
        //System.out.println("delete" +""+ custId);
        Optional<Customer> customer  = getById(custId);
        if (customer.isPresent()){
            this.customerService.delete(customer.get());
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Customer>> getAll() {
        List<Customer> customer = this.customerService.getAll();
        return ResponseEntity.ok(customer);
    }
}
