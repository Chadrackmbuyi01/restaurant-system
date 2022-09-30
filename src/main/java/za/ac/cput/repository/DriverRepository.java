
/*
DriverRepository.java
Repository class for Driver entity
Author : Zubair Esau (217100554)
Date 07 April 2022

 */


package za.ac.cput.repository;

import za.ac.cput.entity.Driver;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class DriverRepository implements IDriverRepository {

    private static DriverRepository repo = null;
    private Set <Driver> driverDB = null;


    private DriverRepository(){
        driverDB = new HashSet<Driver>();
    }

    public static DriverRepository getRepo(){
        if (repo == null){
            repo = new DriverRepository();
        }
        return repo;
    }


    @Override
    public Driver create(Driver driver){
        boolean success = driverDB.add(driver);
        if (!success)
            return null;
        return driver;
    }

    @Override
    public Driver read(String driverId) {

        Driver driver = driverDB.stream()
                .filter(e -> e.getDriverName().equals(e.getDriverName()))
                .findAny()
                .orElse(null);
        return driver;

    }



    @Override
    public Driver update(Driver driver)
    {
        Driver oldDriver = read(driver.getDriverId());
        if (oldDriver != null){
            driverDB.remove(oldDriver);
            driverDB.add(driver);
            return driver;
        }

        return null;
    }

    @Override
    public boolean delete( String driverId) {

        Driver driverToDelete = read(driverId);
        if (driverToDelete == null)
            return false;

        driverDB.remove(driverToDelete);
        return true;

    }

    @Override
    public Set<Driver> getAll() {

        return driverDB;

    }

    @Override
    public Driver save(Driver driver) {
        return null;
    }

    @Override
    public Optional<Driver> findById(String s) {
        return Optional.empty();
    }

    @Override
    public Object findAll() {
        return null;
    }


}

