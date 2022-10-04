package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Payment;
import za.ac.cput.service.entity.PaymentService;

import java.util.List;

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

    @GetMapping("/read/{paymentId}")
    public ResponseEntity<Payment> read(@PathVariable String paymentId) {
        Payment read = this.paymentService.read(paymentId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(read);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(Payment payment) {
        this.paymentService.delete(payment);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("All")
    public ResponseEntity<List<Payment>> getAll() {
        List<Payment> payment = this.paymentService.getAll();
        return ResponseEntity.ok(payment);
    }
}
