package za.ac.cput.repository;

import za.ac.cput.domain.Delivery;

import java.util.Set;

public interface IDeliveryRepository extends IRepository <Delivery,String>{

    public Set<Delivery> getAll();

}

