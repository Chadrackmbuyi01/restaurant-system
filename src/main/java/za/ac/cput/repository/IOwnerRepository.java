package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Owner;

@Repository
public interface IOwnerRepository extends JpaRepository<Owner,Integer> {

}
