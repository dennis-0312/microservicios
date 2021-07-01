package academy.digitallab.store.product.service.imp;

import academy.digitallab.store.product.entity.Category;
import academy.digitallab.store.product.entity.Product;
import academy.digitallab.store.product.repository.ProductRepository;
import academy.digitallab.store.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> listAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product createProduct(Product product) {
        product.setStatus("CREATED");
        product.setCreateAt(new Date());
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return null;
    }

    @Override
    public Product deleteProduct(Long id) {
        return null;
    }

    @Override
    public List<Product> findByCategory(Category category) {
        return null;
    }

    @Override
    public Product updateStock(Long id, Double quantity) {
        Product productBD = getProduct(id);
        if (productBD == null){
            return null;
        }

        Double stock = productBD.getStock() + quantity;
        productBD.setStock(stock);
        return productRepository.save(productBD);
    }
}
