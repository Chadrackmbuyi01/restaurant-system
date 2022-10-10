package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.Owner;
import za.ac.cput.service.entity.OwnerService;


import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("restaurant/owner/")
public class OwnerController {
    private final OwnerService ownerService;
    @Autowired
    public OwnerController (OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping("/save")
    public ResponseEntity<Owner> save(@RequestBody Owner owner)
    {
        System.out.println("save"+owner);
        Owner owner1= this.ownerService.save(owner);
        return  ResponseEntity.ok(owner1);
    }
    private Optional<Owner> getById(int ownerId){
        return this.ownerService.read(ownerId);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Owner> read(@PathVariable  int id) {
        Owner read=this.ownerService.read(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(read);
    }

    @DeleteMapping("delete/{ownerId}")
    public  ResponseEntity<Void> delete(@PathVariable int ownerId)
    {
        //log.info("delete request:{}",ownerId);
        System.out.println("delete" +""+ ownerId);
        Optional<Owner> owner  = getById(ownerId);
        if (owner.isPresent()){
            this.ownerService.delete(owner.get());
        }

        return  ResponseEntity.noContent().build();
    }

    @GetMapping("All")
    public ResponseEntity<List<Owner>> getAll(){
        List<Owner> owner = this.ownerService.getAll();
        return ResponseEntity.ok(owner);
    }
}
