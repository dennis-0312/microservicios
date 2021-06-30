package academy.digitallab.store.shopping.service.imp;

import academy.digitallab.store.shopping.repository.InvoiceRepository;
import academy.digitallab.store.shopping.repository.entity.Invoice;
import academy.digitallab.store.shopping.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InvoiceServiceImp implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public List<Invoice> findInvoiceAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public Invoice create(Invoice invoice) {
        return null;
    }
}
