package com.example.municipalServices.Controller;

import com.example.municipalServices.Model.Bill;
import com.example.municipalServices.Repository.BillRepository;
import com.example.municipalServices.Service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bills")
public class BillController {

    private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @Autowired
    private BillRepository billRepository;

    // Create a new Bill (POST request)
    @PostMapping
    public ResponseEntity<Bill> createBill(@RequestBody Bill bill) {
        Bill createdBill = billService.createBill(bill);
        if (createdBill != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdBill);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    // Get all Bills (GET request)
    @GetMapping
    public ResponseEntity<List<Bill>> getAllBills() {
        try {
            List<Bill> bills = billRepository.findAll();
            if (bills.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(bills, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get a Bill by ID (GET request)
    @GetMapping("/{id}")
    public ResponseEntity<Bill> getBillById(@PathVariable("id") Long id) {
        Optional<Bill> billData = billRepository.findById(id);
        return billData.map(bill -> new ResponseEntity<>(bill, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update an existing Bill (PUT request)
    @PutMapping("/{billId}")
    public ResponseEntity<Bill> updateBill(@PathVariable Long billId, @RequestBody Bill bill) {
        // Call the update service
        Bill updatedBill = billService.updateBill(billId, bill);

        if (updatedBill == null) {
            // Return 404 Not Found if the Bill or related Huduma is not found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // Return the updated Bill with 200 OK status
        return ResponseEntity.ok(updatedBill);
    }

    // Delete a Bill (DELETE request)
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteBill(@PathVariable("id") Long id) {
        try {
            billRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
