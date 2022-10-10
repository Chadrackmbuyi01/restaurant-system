package za.ac.cput.service.entity.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Owner;
import za.ac.cput.repository.IOwnerRepository;
import za.ac.cput.service.entity.OwnerService;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerServiceImpl implements OwnerService {
    protected IOwnerRepository repository;
    @Autowired
    public OwnerServiceImpl(IOwnerRepository repository) {
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

        this.repository.delete(owner);
    }

    @Override
    public List<Owner> getAll() {
        return this.repository.findAll();
    }

    @Override
    public void deleteById(int ownerId) {

    }

}
