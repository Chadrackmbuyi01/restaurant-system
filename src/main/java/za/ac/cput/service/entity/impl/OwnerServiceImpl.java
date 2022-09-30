package za.ac.cput.service.entity.impl;

import org.springframework.beans.factory.annotation.Autowired;
/*
 *OwnerServiceImpl.java
 * VuyolwethuKalolo
 * 214015637
 * 30-09-2022
 */
import za.ac.cput.entity.Owner;
import za.ac.cput.repository.OwnerRepository;
import za.ac.cput.service.entity.OwnerService;

import java.util.List;
import java.util.Optional;


public class OwnerServiceImpl implements OwnerService {
    protected OwnerRepository repository;
    @Autowired
    public OwnerServiceImpl(OwnerRepository repository) {
        this.repository = repository;
    }
    @Override
    public Owner save(Owner owner) {
        return this.repository.save(owner);
    }

    @Override
    public Optional<Owner> read(Integer integer) {
        return this.repository.findById(integer);
    }

   @Override
    public void delete(Owner owner) {

        this.repository.delete(String.valueOf(owner));
    }

    @Override
    public List<Owner> getAll() {
        return this.repository.findAll();
    }
}
