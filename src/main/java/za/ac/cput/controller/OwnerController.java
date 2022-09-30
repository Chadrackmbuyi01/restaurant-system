package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.entity.Owner;
import za.ac.cput.service.entity.OwnerService;

import java.util.List;


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

    @GetMapping("/read/{id}")
    public ResponseEntity<Owner> read(@PathVariable  int id) {
        Owner read=this.ownerService.read(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(read);
    }

    @DeleteMapping("/delete")
    public  ResponseEntity<Void> delete(Owner owner)
    {
        this.ownerService.delete(owner);

        return  ResponseEntity.noContent().build();
    }

    @GetMapping("All")
    public ResponseEntity<List<Owner>> getAll(){
        List<Owner> owner = this.ownerService.getAll();
        return ResponseEntity.ok(owner);
    }
}
