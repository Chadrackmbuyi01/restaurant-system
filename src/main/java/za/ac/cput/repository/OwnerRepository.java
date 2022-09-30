package za.ac.cput.repository;

import za.ac.cput.entity.Owner;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class OwnerRepository implements IOwnerRepository {
    private static OwnerRepository repository=null;
    private Set<Owner> onwerDB=null;//

    private OwnerRepository(){
        onwerDB = new HashSet<>();

    }
    public static OwnerRepository getRepository(){
        if (repository==null){
            repository=new OwnerRepository();
        }
        return repository;
    }



    @Override
    public Owner create(Owner owner) {
        boolean success= onwerDB.add(owner);
        if (!success)
            return null;
        return owner;
    }


    @Override
    public Owner read (String ownerId) {

        Owner owner= onwerDB.stream()
                .filter(e-> e.getOwnerName().equals(e.getOwnerName()))
                .findAny()
                .orElse(null);
        return owner;

    }

    @Override
    public Owner  update(Owner owner) {
        Owner iowner=read(owner.getOwnerName());
        if(iowner !=null){

            onwerDB.remove(iowner);
            onwerDB.add(iowner);
            return owner;
        }
        return null;
    }

    @Override
    public boolean delete(String ownerId) {
        Owner ownerToDelete= read(ownerId);
        if (ownerToDelete == null)
            return false;
        onwerDB.remove(ownerToDelete);
        return true;
    }

    @Override
    public Set<Owner> getAll() {
        return onwerDB;
    }

    public Owner save(Owner owner) {
        return owner;
    }

    public Optional<Owner> findById(Integer integer) {

        return null;
    }

    public List<Owner> findAll() {
        return  null;
    }
}
