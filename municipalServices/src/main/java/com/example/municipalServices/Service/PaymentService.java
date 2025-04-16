package com.example.municipalServices.Service;

import com.example.municipalServices.Model.Bill;
import com.example.municipalServices.Model.Payment;
import com.example.municipalServices.Repository.BillRepository;
import com.example.municipalServices.Repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final BillRepository billRepository;

    public PaymentService(PaymentRepository paymentRepository, BillRepository billRepository) {
        this.paymentRepository = paymentRepository;
        this.billRepository = billRepository;
    }

    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }

    public Payment getById(Long id) {
        return paymentRepository.findById(id).orElse(null);
    }

    public Payment save(Payment payment, Long billId) {
        Bill bill = billRepository.findById(billId).orElseThrow();
        payment.setBill(bill);
        return paymentRepository.save(payment);
    }

    public void delete(Long id) {
        paymentRepository.deleteById(id);
    }

    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Payment updatePayment(Long id, Payment newPayment) {
        Payment existing = paymentRepository.findById(id).orElseThrow();
        existing.setAmountPaid(newPayment.getAmountPaid());
        existing.setDate(newPayment.getDate());
        existing.setBill(newPayment.getBill());
        return paymentRepository.save(existing); // ← Important: return full object
    }


    public Payment getPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId).orElse(null);  // Return null if not found
    }
}
