package academy.digitallab.store.shopping.repository;

import academy.digitallab.store.shopping.repository.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
