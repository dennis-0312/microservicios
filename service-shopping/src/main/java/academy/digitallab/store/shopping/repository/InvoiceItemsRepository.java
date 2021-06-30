package academy.digitallab.store.shopping.repository;

import academy.digitallab.store.shopping.repository.entity.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceItemsRepository extends JpaRepository<InvoiceItem, Long> {
}
