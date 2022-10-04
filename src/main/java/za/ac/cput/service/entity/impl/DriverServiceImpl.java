package za.ac.cput.service.entity.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Driver;
import za.ac.cput.repository.IDriverRepository;
import za.ac.cput.service.entity.DriverService;

import java.util.List;
import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverService {

   protected IDriverRepository repository;

    @Autowired
    public DriverServiceImpl(IDriverRepository repository){
        this.repository = repository;
    }


    @Override
    public Driver save(Driver driver) {
        return this.repository.save(driver);
    }

    @Override
    public Optional<Driver> read(String s) {
        return this.repository.findById(s);
    }

    @Override
    public void delete(Driver driver) {
        this.repository.delete(driver);
    }

    @Override
    public List<Driver> getAll(){
        return this.repository.findAll();
    }

    @Override
    public void deleteById(String DriverId) {

    }


}
