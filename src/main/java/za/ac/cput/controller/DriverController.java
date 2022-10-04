package za.ac.cput.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Driver;
import za.ac.cput.service.entity.DriverService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("restaurant/driver/")
@Slf4j
public class DriverController {

    private final DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }


    @PostMapping("save")
    public ResponseEntity<Driver> save(@RequestBody Driver adress){
        log.info("Save: {}",adress);
        Driver driver = driverService.save(adress);
        return ResponseEntity.ok(driver);
    }

    @GetMapping("read/{driverName}")
    public ResponseEntity<Driver> read(@PathVariable String driverName){
        log.info("Reading request: {}",driverName);
        Driver driver = getById(driverName)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND)); //ZUBAIR REMINDER TO ADD SMTHG!!
        return ResponseEntity.ok(driver);
    }
    private Optional<Driver> getById(String unitNumber){
        return this.driverService.read(unitNumber);
    }

    @DeleteMapping("delete/{driverName}")
    public ResponseEntity<Void> delete(@PathVariable String driverName){
        log.info("Reading request: {}",driverName);
        Optional<Driver> driver  = getById(driverName);
        if (driver.isPresent()){
            this.driverService.delete(driver.get());
        }
        return ResponseEntity.noContent().build();
    }


    @GetMapping("all")
    public ResponseEntity<List<Driver>> getAll(){
        List<Driver> driver = this.driverService.getAll();
        return ResponseEntity.ok(driver);
    }


















}
