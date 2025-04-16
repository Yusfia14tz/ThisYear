package com.example.municipalServices.Service;

import com.example.municipalServices.Model.Bill;
import com.example.municipalServices.Model.Huduma;
import com.example.municipalServices.Repository.BillRepository;
import com.example.municipalServices.Repository.HudumaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillService {

    @Autowired
    private final BillRepository billRepository;
    private final HudumaRepository hudumaRepository;

    public BillService(BillRepository billRepository, HudumaRepository hudumaRepository) {
        this.billRepository = billRepository;
        this.hudumaRepository = hudumaRepository;
    }

    @Transactional
    public Bill updateBill(Long billId, Bill bill) {
        // Fetch existing bill from the database
        Bill existingBill = billRepository.findById(billId).orElse(null);

        if (existingBill == null) {
            // Return null if Bill is not found
            return null;
        }

        // Fetch related Huduma if it exists
        Huduma huduma = hudumaRepository.findById(bill.getHuduma().getId()).orElse(null);

        if (huduma == null) {
            // If Huduma is not found, handle it accordingly
            return null;
        }

        // Update Bill details
        existingBill.setAmount(bill.getAmount());
        existingBill.setStatus(bill.getStatus());
        existingBill.setControlNo(bill.getControlNo());
        existingBill.setHuduma(huduma);

        // Save and return the updated Bill
        return billRepository.save(existingBill);
    }

    public Bill saveBillWithHuduma(Bill bill, Huduma huduma) {
        // Save the Huduma entity first
        hudumaRepository.save(huduma);

        // Now save the Bill entity with the persisted Huduma
        bill.setHuduma(huduma);
        return billRepository.save(bill);
    }

    public Bill createBill(Bill bill) {
        if (bill.getHuduma() != null && bill.getHuduma().getId() != null) {
            // Check if the related Huduma exists
            Huduma huduma = hudumaRepository.findById(bill.getHuduma().getId())
                    .orElseThrow(() -> new RuntimeException("Huduma not found"));

            bill.setHuduma(huduma);  // Set the found Huduma

            return billRepository.save(bill);  // Save and return the Bill object
        }
        return null;  // Return null if Huduma is not provided or invalid
    }



    // Retrieve a Bill by its ID
    public Optional<Bill> getBillById(Long id) {
        return billRepository.findById(id);
    }

    // Retrieve all Bills
    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    // Update an existing Bill
    public Bill updateBill(Bill bill) {
        return billRepository.save(bill);
    }

    // Delete a Bill by its ID
    public void deleteBill(Long id) {
        billRepository.deleteById(id);
    }

}
