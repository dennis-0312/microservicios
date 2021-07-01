package academy.digitallab.store.product.controller;

import academy.digitallab.store.product.entity.Category;
import academy.digitallab.store.product.entity.Product;
import academy.digitallab.store.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    // -------------------Retrieve All Products--------------------------------------------

    @GetMapping("/all")
    public ResponseEntity<List<Product>> listProduct() {
//        return new ResponseEntity<>(productService.listAllProduct(), HttpStatus.OK);
        List<Product> products = productService.listAllProduct();
        if (products.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);


//        if (null == categoryId) {
//            products = productService.listAllProduct();
//            if (products.isEmpty()) {
//                return ResponseEntity.noContent().build();
//            }
//        } else {
//            //Aquí le estamos construyendo una cetegoria y le estamos pasando la categoría
//            products = productService.findByCategory(Category.builder().id(categoryId).build());
//            if (products.isEmpty()) {
//                return ResponseEntity.notFound().build();
//            }
//        }
//        return ResponseEntity.ok(products);
    }

    // -------------------Retrieve Single Product------------------------------------------

    @GetMapping("/getproduct/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) {
        Product products = productService.getProduct(id);
        if (products == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }

    // -------------------Create a Product------------------------------------------------

    @PostMapping("/save")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product productCreate = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productCreate);
    }
//    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product, BindingResult result) {
//        if (result.hasErrors()) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatMessage(result));
//        }
//        Product productCreate = productService.createProduct(product);
//        return ResponseEntity.status(HttpStatus.CREATED).body(productCreate);
//    }

    // -------------------Update a Product-----------------------------------------------

    @PutMapping("/updatestock/{id}/stock")
    public ResponseEntity<Product> updateStockProduct(@PathVariable("id") Long id,@RequestParam(name = "quantity", required = true) Double quantity){
        Product product = productService.updateStock(id, quantity);
        if (product == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }
}
