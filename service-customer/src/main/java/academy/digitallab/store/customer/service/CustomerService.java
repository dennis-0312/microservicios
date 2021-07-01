package academy.digitallab.store.customer.service;

import academy.digitallab.store.customer.repository.entity.Customer;
import academy.digitallab.store.customer.repository.entity.Region;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    public List<Customer> findByAll();
    public List<Customer> findCustomersByRegion(Region region);
    public  Customer getCustomer(Long id);
}
