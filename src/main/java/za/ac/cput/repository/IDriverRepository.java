/*
IDriverRepository.java
Interface class for Driver entity
Author : Zubair Esau (217100554)
Date 07 April 2022

 */

package za.ac.cput.repository;

import za.ac.cput.entity.Driver;

import java.util.Optional;
import java.util.Set;

public interface IDriverRepository extends IRepository <Driver,String>{

    public Set<Driver> getAll();

    Driver save(Driver driver);

    Optional<Driver> findById(String s);

    Object findAll();
}


