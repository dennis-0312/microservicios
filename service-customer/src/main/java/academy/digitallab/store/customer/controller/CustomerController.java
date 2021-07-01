package academy.digitallab.store.customer.controller;

import academy.digitallab.store.customer.repository.entity.Customer;
import academy.digitallab.store.customer.repository.entity.Region;
import academy.digitallab.store.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> findByAll() {
        List<Customer> customers = customerService.findByAll();
        if (customers.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(customers);
        }
    }

    @GetMapping("/getcustomerbyregionid")
    public ResponseEntity<List<Customer>> listAllCustomers(Long regionId){
        List<Customer> customers = new ArrayList<>();
        Region region = new Region();
        region.setId(regionId);
        customers = customerService.findCustomersByRegion(region);
        if (customers == null) {
            log.error("Customers with Region id {} not found.", regionId);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/getcustomer/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long id){
        log.info("Fetching Customer with id {}", id);
        Customer customers = customerService.getCustomer(id);
        if (customers == null){
            log.error("Customer with id {} not found.", id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(customers);
    }
}
