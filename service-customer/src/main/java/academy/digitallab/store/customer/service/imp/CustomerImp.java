package academy.digitallab.store.customer.service.imp;

import academy.digitallab.store.customer.repository.CustomerRepository;
import academy.digitallab.store.customer.repository.entity.Customer;
import academy.digitallab.store.customer.repository.entity.Region;
import academy.digitallab.store.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerImp implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findByAll() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> findCustomersByRegion(Region region) {
        return customerRepository.findByRegion(region);
    }

    @Override
    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElse(null);
    }
}
