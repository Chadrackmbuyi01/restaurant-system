
/*
DeliveryRepository.java
Repository class for Delivery entity
Author : Zubair Esau (217100554)
Date 07 April 2022

 */





package za.ac.cput.repository;

import za.ac.cput.domain.Delivery;

import java.util.HashSet;
import java.util.Set;

public class DeliveryRepository implements IDeliveryRepository {

    private static DeliveryRepository repos = null;
    private Set<Delivery> deliveryDB = null;


    private DeliveryRepository(){
        deliveryDB = new HashSet<Delivery>();
    }

    public static DeliveryRepository getRepo(){
        if (repos == null){
            repos = new DeliveryRepository();
        }
        return repos;
    }


    @Override
    public Delivery create(Delivery delivery){
        boolean success = deliveryDB.add(delivery);
        if (!success)
            return null;
        return delivery;
    }

    @Override
    public Delivery read(String deliveryId) {

        Delivery delivery = deliveryDB.stream()
                .filter(e -> e.getOrderId().equals(e.getOrderId()))
                .findAny()
                .orElse(null);
        return delivery;

    }



    @Override
    public Delivery update(Delivery delivery)
    {
        Delivery newDelivery = read(delivery.getDeliveryId());
        if (newDelivery != null){
            deliveryDB.remove(newDelivery);
            deliveryDB.add(delivery);
            return delivery;
        }

        return null;
    }

    @Override
    public boolean delete( String deliveryId) {

        Delivery deliveryToDelete = read(deliveryId);
        if (deliveryToDelete == null)
            return false;

        deliveryDB.remove(deliveryToDelete);
        return true;

    }

    @Override
    public Set<Delivery> getAll() {

        return deliveryDB;

    }


}



