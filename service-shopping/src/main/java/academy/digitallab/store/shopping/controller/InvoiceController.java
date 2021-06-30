package academy.digitallab.store.shopping.controller;


import academy.digitallab.store.shopping.repository.entity.Invoice;
import academy.digitallab.store.shopping.service.InvoiceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/all")
    public ResponseEntity<List<Invoice>> listAllInvoices(){
        List<Invoice> invoices = invoiceService.findInvoiceAll();
        if (invoices.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.ok(invoices);
        }
    }
}
