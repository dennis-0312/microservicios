package academy.digitallab.store.shopping.client;

import academy.digitallab.store.shopping.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "service-product")
@RequestMapping("/products")
public interface ProductClient {

    @GetMapping("/getproduct/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id);

    @PutMapping("/updatestock/{id}/stock")
    public ResponseEntity<Product> updateStockProduct(@PathVariable("id") Long id,@RequestParam(name = "quantity", required = true) Double quantity);
}
