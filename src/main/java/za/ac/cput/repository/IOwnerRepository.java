package za.ac.cput.repository;
/*
 *IOwnerRepository .java
 * VuyolwethuKalolo
 * 214015637
 * 30-09-2022
 */

import za.ac.cput.entity.Owner;

import java.util.Set;

public interface IOwnerRepository  extends IRepository<Owner,String>{
        public Set<Owner> getAll();
}
