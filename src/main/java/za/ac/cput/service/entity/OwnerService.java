package za.ac.cput.service.entity;

import za.ac.cput.domain.Owner;
import za.ac.cput.service.IService;

import java.util.List;

public interface OwnerService extends IService<Owner,Integer> {
    List<Owner> getAll();
}
