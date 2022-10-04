package za.ac.cput.repository;

import za.ac.cput.domain.Owner;

import java.util.Set;

public interface IOwnerRepository extends IRepository<Owner,String>{
    public Set<Owner> getAll();
}
