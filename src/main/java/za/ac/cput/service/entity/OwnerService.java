package za.ac.cput.service.entity;
/*
 *OwnerService.java
 * VuyolwethuKalolo
 * 214015637
 * 30-09-2022
 */
import za.ac.cput.entity.Owner;
import za.ac.cput.service.IService;

import java.util.List;

public interface OwnerService extends IService<Owner,Integer> {
        List<Owner> getAll();

}
