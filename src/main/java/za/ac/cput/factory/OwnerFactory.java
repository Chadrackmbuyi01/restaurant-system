package za.ac.cput.factory;

import za.ac.cput.entity.Owner;

public class OwnerFactory {

    //creating objects
    public static Owner.Builder createOwner(int ownerId, String ownerName){

        return new Owner.Builder().setOwnwerId(ownerId)
                .setOwnerName(ownerName)
                .build();

    }
}
