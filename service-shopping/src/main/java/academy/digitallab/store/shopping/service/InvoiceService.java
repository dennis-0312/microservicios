package academy.digitallab.store.shopping.service;

import academy.digitallab.store.shopping.repository.entity.Invoice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InvoiceService {
    public List<Invoice> findInvoiceAll();
    public Invoice createInvoice(Invoice invoice);
    public Invoice createSingleInvoice(Invoice invoice);
    public Invoice getInvoice(Long id);
}
