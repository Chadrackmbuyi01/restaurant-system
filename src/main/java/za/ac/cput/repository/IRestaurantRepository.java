package za.ac.cput.repository;

import za.ac.cput.domain.Restaurant;

import java.util.Set;

public interface IRestaurantRepository extends IRepository<Restaurant,String> {
    // The interface of the Employee Repo where I will define create, read, update and delete methods

    public Set<Restaurant> getAll();
}
