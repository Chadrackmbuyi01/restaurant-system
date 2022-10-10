package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Employee;
import za.ac.cput.domain.Payment;
import za.ac.cput.service.entity.PaymentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("restaurant/payment/")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/save")
    public ResponseEntity<Payment> save(@RequestBody Payment payment) {
        System.out.println("save" + payment);
        Payment save = this.paymentService.save(payment);
        return ResponseEntity.ok(save);
    }
    private Optional<Payment> getById(String paymentId) {
        return this.paymentService.read(paymentId);
    }
    @GetMapping("/read/{paymentId}")
    public ResponseEntity<Payment> read(@PathVariable String paymentId) {
        Payment read = this.paymentService.read(paymentId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(read);
    }

    @DeleteMapping("delete/{paymentId}")
    public ResponseEntity<Void> delete(@PathVariable String paymentId) {
        //log.info("delete request:{}",paymentId);
        System.out.println("delete" +""+ paymentId);
        Optional<Payment> payment  = getById(paymentId);
        if (payment.isPresent()){
            this.paymentService.delete(payment.get());
        }
        return ResponseEntity.noContent().build();
//        this.paymentService.delete(paymentId);
//        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Payment>> getAll() {
        List<Payment> payment = this.paymentService.getAll();
        return ResponseEntity.ok(payment);
    }
}
