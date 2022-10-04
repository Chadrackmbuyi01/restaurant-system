/*
IDriverRepository.java
Interface class for Driver entity
Author : Zubair Esau (217100554)
Date 07 April 2022

 */

package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Driver;

@Repository
public interface IDriverRepository extends JpaRepository<Driver,String> {

}


