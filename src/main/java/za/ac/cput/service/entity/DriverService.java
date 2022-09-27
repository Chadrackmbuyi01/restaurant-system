package za.ac.cput.service.entity;

import za.ac.cput.entity.Driver;
import za.ac.cput.service.IService;

import java.util.List;

public interface DriverService extends IService<Driver, String > {

        List<Driver> getAll();

        }
